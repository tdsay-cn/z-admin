package com.z.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.z.admin.entity.form.system.RolePermissionForm;
import com.z.admin.entity.po.SystemRolePermission;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author system
 * @since 2024-09-09
 */
public interface ISystemRolePermissionService extends IService<SystemRolePermission> {

    /**
     * 加载角色权限
     */
    void loadRolePermission();

    /**
     * 根据角色id集合查询权限集合
     */
    Set<Long> queryPermissionByRoleId(List<Long> roleIdList);

    /**
     * 根据角色id查询权限集合
     */
    Set<Long> queryPermissionByRoleId(Long roleId);

    /**
     * 更新角色权限
     */
    void updatePermission(RolePermissionForm form);

    /**
     * 根据角色ID删除角色权限（同时删除数据库和Redis）
     */
    void deleteByRoleId(Long roleId);
}
