package com.z.admin.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author tdsay
 * @description 用户角色
 */
@Data
public class UserRoleInfoDto {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 角色信息集合
     */
    private List<RoleInfoDto> roleInfoDtoList;
}
