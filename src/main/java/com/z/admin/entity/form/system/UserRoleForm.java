package com.z.admin.entity.form.system;

import com.z.admin.validator.ValidId;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tdsay
 * @description 配置用户角色
 */
@Data
public class UserRoleForm {

    /**
     * 用户id
     */
    @ValidId
    private Long userId;

    /**
     * 角色id列表，传空就是清空角色
     */
    private Set<Long> roleIdSet = new HashSet<>();
}
