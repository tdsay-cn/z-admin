package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.z.admin.entity.dto.UserLoginDto;
import com.z.admin.entity.enums.RedisKeyEnum;
import com.z.admin.entity.enums.ResultCodeEnum;
import com.z.admin.entity.form.system.UserLoginForm;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.exception.ServiceException;
import com.z.admin.security.UserDetail;
import com.z.admin.service.*;
import com.z.admin.util.DataUtils;
import com.z.admin.util.JwtUtil;
import com.z.admin.util.LoginUtil;
import com.z.admin.util.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SystemAuthService implements ISystemAuthService {

    @Resource
    private ISystemUserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private ISystemUserRoleService userRoleService;
    @Resource
    private ISystemRolePermissionService rolePermissionService;
    @Resource
    private ISystemUserPermissionService userPermissionService;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public UserLoginDto login(UserLoginForm form) {
        // 根据用户名查询出用户实体对象
        SystemUser user = this.getByUsername(form.getUsername());
        // 若没有查到用户 或者 密码校验失败则抛出自定义异常
        if (DataUtils.isEmpty(user) || !passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw new ServiceException(ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        // 如果用户已禁用
        if (user.getDisabled()) {
            throw new ServiceException(ResultCodeEnum.USER_DISABLED);
        }

        // 查询权限
        Long userId = user.getId();
        List<Long> roleList = this.userRoleService.queryRoleByUserId(userId);
        List<Long> userPermissionList = this.userPermissionService.queryPermissionByUserId(userId);

        // 保存用户登录信息
        String token = JwtUtil.generate(user.getUsername());
        UserLoginDto userLoginDto = UserLoginDto.of(user, roleList, userPermissionList, token);
        redisUtil.set(RedisKeyEnum.USER_INFO, user.getUsername(), userLoginDto);

        return userLoginDto;
    }

    @Override
    public void logout() {
        UserLoginDto userLoginDto = LoginUtil.getLoginUser().getUserLoginDto();
        if (DataUtils.isNotEmpty(userLoginDto)) {
            this.logout(userLoginDto.getUsername());
        }
    }

    @Override
    public UserDetail loadUserByCache(String username) {
        // 缓存查询
        UserLoginDto userLoginDto = redisUtil.getObjectFromRedis(RedisKeyEnum.USER_INFO, username, UserLoginDto.class);
        if (DataUtils.isEmpty(userLoginDto)) {
            return null;
        }
        List<SimpleGrantedAuthority> operatePermissionList = this.genSimpleGrantedAuthority(userLoginDto.getRoleList(), userLoginDto.getPermissionList());
        return new UserDetail(userLoginDto, operatePermissionList);
    }

    @Override
    public void logout(String userName) {
        redisUtil.del(RedisKeyEnum.USER_INFO, userName);
    }

    @Override
    public void logout(Long userId) {
        SystemUser systemUser = this.userService.getById(userId);
        this.logout(systemUser.getUsername());
    }

    /**
     * 通过username查询用户
     */
    private SystemUser getByUsername(String username) {
        LambdaQueryWrapper<SystemUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemUser::getUsername, username);
        return this.userService.getOne(wrapper);
    }

    /**
     * 构建权限
     *
     * @param roleList       用户的角色
     * @param permissionList 用户的指定权限
     */
    private List<SimpleGrantedAuthority> genSimpleGrantedAuthority(List<Long> roleList, List<Long> permissionList) {
        List<SimpleGrantedAuthority> operatePermissionList = new ArrayList<>();
        Set<Long> permissionIdSet = new HashSet<>();
        permissionIdSet.addAll(this.rolePermissionService.queryPermissionByRoleId(roleList));
        permissionIdSet.addAll(permissionList);
        for (Long permissionId : permissionIdSet) {
            operatePermissionList.add(new SimpleGrantedAuthority(permissionId.toString()));
        }

        return operatePermissionList;
    }
}
