package com.z.admin.entity.form.system;

import com.z.admin.validator.ValidId;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tdsay
 * @description 修改用户权限
 */
@Data
public class UserPermissionForm {

    /**
     * 角色id
     */
    @ValidId
    private Long userId;

    /**
     * 权限列表，传空就是清空权限
     */
    private Set<Long> permissionSet = new HashSet<>();
}
