package com.z.admin.entity.vo.system;

import com.z.admin.entity.po.SystemRole;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tdsay
 * @description 角色列表vo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RoleVo extends BaseVo {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    public RoleVo(SystemRole role) {
        BeanUtils.copyPropertiesIgnoreNull(role, this);
    }
}
