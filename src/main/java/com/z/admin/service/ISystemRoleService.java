package com.z.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.z.admin.entity.param.system.RoleQueryParam;
import com.z.admin.entity.po.SystemRole;

import java.util.List;

/**
 * @author tdsay
 * @description
 */
public interface ISystemRoleService extends IService<SystemRole> {

    /**
     * 查询角色列表
     */
    IPage<SystemRole> query(RoleQueryParam param);

    /**
     * 删除角色
     */
    void delete(Long id);

    /**
     * 查询所有角色
     */
    List<SystemRole> all();
}
