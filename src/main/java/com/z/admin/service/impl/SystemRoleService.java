package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemRoleMapper;
import com.z.admin.entity.enums.system.SystemRoleType;
import com.z.admin.entity.param.system.RoleQueryParam;
import com.z.admin.entity.po.SystemRole;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.service.ISystemRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tdsay
 * @description 系统角色
 */
@Service
public class SystemRoleService extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    @Resource
    ISystemRolePermissionService systemRolePermissionService;

    @Override
    public IPage<SystemRole> query(RoleQueryParam param) {
        LambdaQueryWrapper<SystemRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemRole::getType, SystemRoleType.NORMAL.getId());
        return this.page(param.getPage(), wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        this.systemRolePermissionService.deleteByRoleId(id);
        this.removeById(id);
    }

    @Override
    public List<SystemRole> all() {
        return this.list();
    }

}
