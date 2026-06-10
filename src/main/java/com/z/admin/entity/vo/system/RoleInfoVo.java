package com.z.admin.entity.vo.system;

import com.z.admin.entity.po.SystemRole;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tdsay
 * @description 角色信息vo
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleInfoVo extends BaseVo {

    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    public RoleInfoVo() {
    }

    public RoleInfoVo(SystemRole role) {
        BeanUtils.copyPropertiesIgnoreNull(role, this);
    }
}
