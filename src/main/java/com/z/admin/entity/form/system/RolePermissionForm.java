package com.z.admin.entity.form.system;

import com.z.admin.validator.ValidId;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tdsay
 * @description 修改角色权限
 */
@Data
public class RolePermissionForm {

    /**
     * 角色id
     */
    @ValidId
    private Long roleId;

    /**
     * 权限列表
     */
    @NotEmpty(message = "权限不能为空")
    private Set<Long> permissionSet = new HashSet<>();
}
