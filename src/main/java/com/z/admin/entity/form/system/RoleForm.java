package com.z.admin.entity.form.system;

import com.z.admin.entity.form.base.BaseForm;
import com.z.admin.entity.po.SystemRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tdsay
 * @description 新增角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleForm extends BaseForm<SystemRole> {

    /**
     * 角色名称
     */
    @NotBlank
    private String name;

    /**
     * 描述
     */
    private String description;
}
