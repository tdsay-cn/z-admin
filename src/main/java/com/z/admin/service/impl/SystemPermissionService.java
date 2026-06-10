package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemPermissionMapper;
import com.z.admin.entity.dto.PermissionTreeDto;
import com.z.admin.entity.enums.RedisKeyEnum;
import com.z.admin.entity.enums.system.SystemPermissionLevel;
import com.z.admin.entity.enums.system.SystemPermissionType;
import com.z.admin.entity.po.SystemPermission;
import com.z.admin.service.ISystemPermissionService;
import com.z.admin.util.DataUtils;
import com.z.admin.util.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author system
 * @since 2024-09-04
 */
@Service
public class SystemPermissionService extends ServiceImpl<SystemPermissionMapper, SystemPermission> implements ISystemPermissionService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void loadPermission() {
        redisUtil.del(RedisKeyEnum.PERMISSION);
        List<SystemPermission> systemPermissionList = this.queryOperationalPermission();
        if (DataUtils.isEmpty(systemPermissionList)) {
            throw new NullPointerException("systemPermission is must be not null!");
        }

        redisUtil.lSetAll(RedisKeyEnum.PERMISSION, systemPermissionList);
    }

    @Override
    public List<SystemPermission> queryOperationalPermission() {
        LambdaQueryWrapper<SystemPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemPermission::getType, SystemPermissionType.OPERATE.getId());
        return this.list(wrapper);
    }

    @Override
    public List<String> queryAnonymousPermission() {
        return this.redisUtil.lGetAll(RedisKeyEnum.PERMISSION, SystemPermission.class)
                .stream()
                .filter(permission -> SystemPermissionLevel.ANONYMOUS.getId().equals(permission.getAccessLevel()))
                .map(permission -> String.valueOf(permission.getId()))
                .toList();
    }

    @Override
    public List<PermissionTreeDto> queryPermissionTree() {
        LambdaQueryWrapper<SystemPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemPermission::getAccessLevel, SystemPermissionLevel.AUTH.getId());
        List<SystemPermission> list = this.list(wrapper);

        return list.stream()
                .filter(systemPermission -> systemPermission.getParentId().equals(0L))
                .map(permission -> buildTree(permission, list))
                .toList();
    }

    /**
     * 递归构建树形结构
     */
    private PermissionTreeDto buildTree(SystemPermission permission, List<SystemPermission> allPermissions) {
        PermissionTreeDto dto = new PermissionTreeDto();
        dto.setId(permission.getId());
        dto.setName(permission.getName());

        List<PermissionTreeDto> children = allPermissions.stream()
                .filter(p -> p.getParentId().equals(permission.getId()))
                .map(p -> buildTree(p, allPermissions))
                .toList();
        dto.setChildren(children);

        return dto;
    }
}