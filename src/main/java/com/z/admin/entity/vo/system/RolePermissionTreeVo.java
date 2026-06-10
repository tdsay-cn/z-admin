package com.z.admin.entity.vo.system;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class RolePermissionTreeVo {

    /**
     * 当前角色的权限列表
     */
    private Set<Long> currentRolePermissionIdSet;

    /**
     * 树形结构
     */
    private List<PermissionTreeNodeVo> permissionTree;
}