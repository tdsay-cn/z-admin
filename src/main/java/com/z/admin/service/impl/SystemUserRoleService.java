package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.SystemUserRoleMapper;
import com.z.admin.entity.dto.RoleInfoDto;
import com.z.admin.entity.dto.UserRoleInfoDto;
import com.z.admin.entity.form.system.UserRoleForm;
import com.z.admin.entity.po.SystemRole;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.entity.po.SystemUserRole;
import com.z.admin.exception.ServiceException;
import com.z.admin.service.ISystemRoleService;
import com.z.admin.service.ISystemUserRoleService;
import com.z.admin.service.ISystemUserService;
import com.z.admin.util.CollectionUtils;
import com.z.admin.util.DataUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关联 服务实现类
 * </p>
 *
 * @author system
 * @since 2024-09-04
 */
@Service
public class SystemUserRoleService extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements ISystemUserRoleService {

    @Resource
    private ISystemRoleService systemRoleService;
    @Resource
    private ISystemUserService systemUserService;

    @Override
    public List<Long> queryRoleByUserId(Long userId) {
        LambdaQueryWrapper<SystemUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(SystemUserRole::getRoleId)
                .eq(SystemUserRole::getUserId, userId);
        return this.listObjs(wrapper, e -> (Long) e);
    }

    @Override
    public Map<Long, UserRoleInfoDto> queryRoleInfoByUserIdList(List<Long> userIdList) {
        LambdaQueryWrapper<SystemUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(SystemUserRole::getUserId, userIdList);
        List<SystemUserRole> systemUserRoleList = this.list(wrapper);

        Map<Long, SystemRole> roleIdMap = systemRoleService.list()
                .stream()
                .collect(Collectors.toMap(SystemRole::getId, r -> r));

        return systemUserRoleList.stream()
                .collect(Collectors.groupingBy(
                        SystemUserRole::getUserId,
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        ur -> {
                                            SystemRole role = roleIdMap.get(ur.getRoleId());
                                            if (role == null) {
                                                return null;
                                            }
                                            RoleInfoDto roleInfoDto = new RoleInfoDto();
                                            roleInfoDto.setId(role.getId());
                                            roleInfoDto.setName(role.getName());
                                            return roleInfoDto;
                                        },
                                        Collectors.toList()
                                ),
                                roleInfoDtoList -> {
                                    UserRoleInfoDto dto = new UserRoleInfoDto();
                                    dto.setRoleInfoDtoList(roleInfoDtoList);
                                    return dto;
                                }
                        )
                ));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserRole(UserRoleForm form) {
        Long userId = form.getUserId();
        Set<Long> newRoleIdSet = form.getRoleIdSet();

        if (userId == null) {
            throw new ServiceException("用户ID不能为空");
        }

        SystemUser systemUser = systemUserService.getById(userId);
        if (DataUtils.isEmpty(systemUser)) {
            throw new ServiceException("用户不存在");
        }

        // 查询用户当前的角色
        Set<Long> oldRoleIdSet = new HashSet<>(queryRoleByUserId(userId));
        Set<Long> newRoleIdSetCopy = new HashSet<>(newRoleIdSet);

        // 计算需要删除和新增的角色
        Set<Long> toRemove = CollectionUtils.computeToRemove(oldRoleIdSet, newRoleIdSetCopy);
        Set<Long> toAdd = CollectionUtils.computeToAdd(oldRoleIdSet, newRoleIdSetCopy);

        // 删除角色关联
        if (!toRemove.isEmpty()) {
            LambdaQueryWrapper<SystemUserRole> deleteWrapper = new LambdaQueryWrapper<>();
            deleteWrapper.eq(SystemUserRole::getUserId, userId)
                    .in(SystemUserRole::getRoleId, toRemove);
            this.remove(deleteWrapper);
        }

        // 新增角色关联
        if (!toAdd.isEmpty()) {
            List<SystemUserRole> userRoleList = toAdd.stream()
                    .map(roleId -> {
                        SystemUserRole userRole = new SystemUserRole();
                        userRole.setUserId(userId);
                        userRole.setRoleId(roleId);
                        return userRole;
                    })
                    .collect(Collectors.toList());
            this.saveBatch(userRoleList);
        }
    }
}
