package com.z.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.z.admin.entity.dto.RoleInfoDto;
import com.z.admin.entity.dto.UserRoleInfoDto;
import com.z.admin.entity.enums.ResultCodeEnum;
import com.z.admin.entity.form.system.*;
import com.z.admin.entity.param.system.UserQueryParam;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.entity.vo.base.Result;
import com.z.admin.entity.vo.system.RoleInfoVo;
import com.z.admin.entity.vo.system.UserInfoVo;
import com.z.admin.entity.vo.system.UserVo;
import com.z.admin.exception.ServiceException;
import com.z.admin.service.ISystemUserPermissionService;
import com.z.admin.service.ISystemUserRoleService;
import com.z.admin.service.ISystemUserService;
import com.z.admin.util.BeanUtils;
import com.z.admin.util.DataUtils;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 * @author tdsay
 * @description 用户管理
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    ISystemUserService systemUserService;
    @Resource
    ISystemUserRoleService systemUserRoleService;
    @Resource
    ISystemUserPermissionService systemUserPermissionService;

    /**
     * 新增用户
     *
     * @param form 用户信息
     */
    @PostMapping("/add")
    public Result<BaseVo> add(@Valid @RequestBody UserAddForm form) {
        SystemUser systemUser = form.toPo();
        systemUserService.save(systemUser);
        return Result.success(systemUser.toVO(BaseVo.class));
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable("id") Long id) {
        if (id == 1) {
            throw new ServiceException(ResultCodeEnum.FAIL, "超管不可以被删除");
        }
        systemUserService.removeById(id);
        return Result.success();
    }

    /**
     * 修改用户信息
     *
     * @param form 用户信息
     */
    @PutMapping
    public Result<?> update(@Valid @RequestBody UserUpdateForm form) {
        systemUserService.updateById(form.toPo());
        return Result.success();
    }

    /**
     * 修改用户密码
     */
    @PutMapping("/password")
    public Result<?> updatePassword(@Valid @RequestBody UserUpdatePwdForm form) {
        systemUserService.updatePassWord(form);
        return Result.success();
    }

    /**
     * 用户详情
     *
     * @param id 用户id
     */
    @GetMapping("/{id}")
    public Result<UserInfoVo> detail(@PathVariable("id") Long id) {
        SystemUser user = systemUserService.getById(id);
        return Result.success(user.toVO(UserInfoVo.class));
    }

    /**
     * 用户列表
     *
     * @param param 列表查询参数
     */
    @PostMapping("/list")
    public Result<IPage<UserVo>> list(@RequestBody UserQueryParam param) {
        IPage<SystemUser> iPage = systemUserService.query(param);
        List<Long> uidList = iPage.getRecords().stream().map(SystemUser::getId).toList();
        Map<Long, UserRoleInfoDto> userRoleInfoDtoMap = this.systemUserRoleService.queryRoleInfoByUserIdList(uidList);

        return Result.success(iPage.convert(user -> {
            UserVo userVo = new UserVo(user);
            UserRoleInfoDto userRoleInfoDto = userRoleInfoDtoMap.get(user.getId());
            if (userRoleInfoDto != null) {
                List<RoleInfoDto> roleInfoDtoList = userRoleInfoDto.getRoleInfoDtoList();
                if (DataUtils.isNotEmpty(roleInfoDtoList)) {
                    List<RoleInfoVo> roleVoList = BeanUtils.copyListProperties(roleInfoDtoList, RoleInfoVo::new);
                    userVo.setRoleInfoList(roleVoList);
                }
            }
            return userVo;
        }));
    }

    /**
     * 修改用户权限
     */
    @PutMapping("/permission")
    public Result<?> update(@Valid @RequestBody UserPermissionForm form) {
        systemUserPermissionService.updatePermission(form);
        return Result.success();
    }

    /**
     * 配置用户角色
     */
    @PutMapping("/role")
    public Result<?> updateUserRole(@Valid @RequestBody UserRoleForm form) {
        systemUserRoleService.updateUserRole(form);
        return Result.success();
    }

}
