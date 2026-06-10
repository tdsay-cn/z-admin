package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemRolePermissionMapper;
import com.z.admin.entity.dto.RedisRolePermissionDto;
import com.z.admin.entity.enums.RedisKeyEnum;
import com.z.admin.entity.enums.system.SystemRoleType;
import com.z.admin.entity.form.system.RolePermissionForm;
import com.z.admin.entity.po.SystemRole;
import com.z.admin.entity.po.SystemRolePermission;
import com.z.admin.exception.ServiceException;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.util.CollectionUtils;
import com.z.admin.util.DataUtils;
import com.z.admin.util.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author system
 * @since 2024-09-09
 */
@Service
public class SystemRolePermissionService extends ServiceImpl<SystemRolePermissionMapper, SystemRolePermission> implements ISystemRolePermissionService {

    @Resource
    RedisUtil redisUtil;
    @Resource
    SystemRoleService systemRoleService;

    @Override
    public void loadRolePermission() {
        redisUtil.del(RedisKeyEnum.ROLE_PERMISSION.getKey());

        List<SystemRolePermission> list = this.list();
        if (DataUtils.isEmpty(list)) {
            return;
        }

        List<RedisRolePermissionDto> dtoList = list.stream()
                .collect(Collectors.groupingBy(
                        SystemRolePermission::getRoleId,
                        Collectors.mapping(SystemRolePermission::getPermissionId, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .map(e -> new RedisRolePermissionDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        redisUtil.lSetAll(RedisKeyEnum.ROLE_PERMISSION, dtoList);
    }

    @Override
    public Set<Long> queryPermissionByRoleId(List<Long> roleIdList) {
        if (DataUtils.isEmpty(roleIdList)) {
            return new HashSet<>();
        }

        return this.redisUtil.lGetAll(RedisKeyEnum.ROLE_PERMISSION, RedisRolePermissionDto.class)
                .stream()
                .filter(e -> roleIdList.contains(e.getRoleId()))
                .flatMap(e -> e.getPermissionIdList().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Long> queryPermissionByRoleId(Long roleId) {
        LambdaQueryWrapper<SystemRolePermission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(SystemRolePermission::getPermissionId).eq(SystemRolePermission::getRoleId, roleId);
        return this.listObjs(queryWrapper)
                .stream()
                .map(obj -> (Long) obj)
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePermission(RolePermissionForm form) {
        Long roleId = form.getRoleId();
        Set<Long> newPermissionList = form.getPermissionSet();

        if (roleId == null) {
            throw new ServiceException("角色ID不能为空");
        }

        SystemRole systemRole = this.systemRoleService.getById(roleId);
        if (DataUtils.isEmpty(systemRole)) {
            throw new ServiceException("角色不存在");
        }

        if (systemRole.getType().equals(SystemRoleType.SUPPER.getId())) {
            throw new ServiceException("超管权限不可以修改");
        }

        Set<Long> oldPermissionSet = queryPermissionByRoleId(roleId);
        Set<Long> newPermissionSet = new HashSet<>(newPermissionList);

        Set<Long> toRemove = CollectionUtils.computeToRemove(oldPermissionSet, newPermissionSet);
        Set<Long> toAdd = CollectionUtils.computeToAdd(oldPermissionSet, newPermissionSet);

        if (!toRemove.isEmpty()) {
            LambdaQueryWrapper<SystemRolePermission> deleteWrapper = new LambdaQueryWrapper<>();
            deleteWrapper.eq(SystemRolePermission::getRoleId, roleId)
                    .in(SystemRolePermission::getPermissionId, toRemove);
            this.remove(deleteWrapper);
        }

        if (!toAdd.isEmpty()) {
            List<SystemRolePermission> toAddList = toAdd.stream()
                    .map(permissionId -> {
                        SystemRolePermission rolePermission = new SystemRolePermission();
                        rolePermission.setRoleId(roleId);
                        rolePermission.setPermissionId(permissionId);
                        return rolePermission;
                    })
                    .collect(Collectors.toList());
            this.saveBatch(toAddList);
        }

        this.loadRolePermission();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleId(Long roleId) {
        // 从数据库删除
        LambdaQueryWrapper<SystemRolePermission> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(SystemRolePermission::getRoleId, roleId);
        this.remove(deleteWrapper);

        // 从 Redis 删除
        redisUtil.lRemoveIf(RedisKeyEnum.ROLE_PERMISSION, RedisRolePermissionDto.class,
                dto -> dto.getRoleId().equals(roleId));
    }

}
