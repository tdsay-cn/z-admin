package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemUserMapper;
import com.z.admin.entity.enums.system.SystemUserType;
import com.z.admin.entity.form.system.UserUpdatePwdForm;
import com.z.admin.entity.param.system.UserQueryParam;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.service.ISystemAuthService;
import com.z.admin.service.ISystemUserService;
import com.z.admin.util.DataUtils;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author tdsay
 * @description 系统用户
 * <p>
 * <p>
 * //     * todo 待处理
 * //     * 权限分为直接指定用户的权限和用户关联角色的权限.
 * //     * <p>
 * //     * 修改用户权限后，更新缓存、更新数据库、注销用户登录状态
 * //     * 修改用户角色后，更新缓存、更新数据库、注销用户登录状态
 * //     * <p>
 * //     * 角色关联权限每次都通过缓存查询，修改时 更新缓存、更新数据
 */
@Service
public class SystemUserService extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    @Lazy
    private ISystemAuthService systemAuthService;

    @Override
    public IPage<SystemUser> query(UserQueryParam param) {
        LambdaQueryWrapper<SystemUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemUser::getType, SystemUserType.NORMAL.getId());
        wrapper.eq(DataUtils.idIsNotNull(param.getId()), SystemUser::getId, param.getId());
        wrapper.eq(DataUtils.isNotEmpty(param.getMobile()), SystemUser::getEmail, param.getMobile());
        wrapper.like(DataUtils.isNotEmpty(param.getNickName()), SystemUser::getNickName, param.getNickName());
        return this.page(param.getPage(), wrapper);
    }

    @Override
    public void updatePassWord(UserUpdatePwdForm form) {
        SystemUser systemUser = this.getById(form.getId());
        systemUser.setPassword(passwordEncoder.encode(form.getPassword()));
        this.updateById(systemUser);
        // 登出
        this.systemAuthService.logout(systemUser.getUsername());
    }
}

