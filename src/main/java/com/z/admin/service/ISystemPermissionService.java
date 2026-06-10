package com.z.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.z.admin.entity.dto.PermissionTreeDto;
import com.z.admin.entity.po.SystemPermission;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author system
 * @since 2024-09-04
 */
public interface ISystemPermissionService extends IService<SystemPermission> {

    /**
     * 加载权限路由
     */
    void loadPermission();

    /**
     * 通过数据库查询权限
     */
    List<SystemPermission> queryOperationalPermission();

    /**
     * 查询匿名访问权限
     */
    List<String> queryAnonymousPermission();

    /**
     * 查询权限tree
     */
    List<PermissionTreeDto> queryPermissionTree();
}