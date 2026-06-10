package com.z.admin.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class PermissionTreeDto {

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
    private List<PermissionTreeDto> children;
}