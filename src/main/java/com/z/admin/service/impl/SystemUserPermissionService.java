package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemUserPermissionMapper;
import com.z.admin.entity.form.system.UserPermissionForm;
import com.z.admin.entity.po.SystemUserPermission;
import com.z.admin.service.ISystemAuthService;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.service.ISystemUserPermissionService;
import com.z.admin.service.ISystemUserRoleService;
import com.z.admin.util.DataUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户权限关联 服务实现类
 * </p>
 *
 * @author system
 * @since 2024-09-04
 */
@Service
public class SystemUserPermissionService extends ServiceImpl<SystemUserPermissionMapper, SystemUserPermission> implements ISystemUserPermissionService {

    @Resource
    ISystemUserRoleService systemUserRoleService;
    @Resource
    ISystemRolePermissionService systemRolePermissionService;
    @Resource
    ISystemAuthService systemAuthService;

    @Override
    public List<Long> queryPermissionByUserId(Long userId) {
        LambdaQueryWrapper<SystemUserPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemUserPermission::getPermissionId)
                .eq(SystemUserPermission::getUserId, userId);
        return this.listObjs(wrapper, e -> (Long) e);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePermission(UserPermissionForm form) {
        Long userId = form.getUserId();
        Set<Long> permissionSet = form.getPermissionSet();
        List<Long> roleIdList = systemUserRoleService.queryRoleByUserId(userId);
        Set<Long> rolePermissionSet = new HashSet<>();
        if (DataUtils.isNotEmpty(roleIdList)) {
            rolePermissionSet = this.systemRolePermissionService.queryPermissionByRoleId(roleIdList);
        }

        // 除去角色有的权限
        permissionSet.removeAll(rolePermissionSet);

        // 删除所有之前的权限
        LambdaQueryWrapper<SystemUserPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(SystemUserPermission::getUserId, userId);
        this.remove(wrapper);

        // 保存权限
        List<SystemUserPermission> list = new ArrayList<>();
        for (Long permissionId : permissionSet) {
            SystemUserPermission systemUserPermission = new SystemUserPermission();
            systemUserPermission.setUserId(userId);
            systemUserPermission.setPermissionId(permissionId);
            list.add(systemUserPermission);
        }
        this.saveBatch(list);

        // 登出
        this.systemAuthService.logout(userId);
    }
}
