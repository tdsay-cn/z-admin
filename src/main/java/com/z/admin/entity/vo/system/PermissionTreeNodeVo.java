package com.z.admin.entity.vo.system;

import lombok.Data;

import java.util.List;

@Data
public class PermissionTreeNodeVo {

    /**
     * 权限id
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限子集
     */
    private List<PermissionTreeNodeVo> children;
}