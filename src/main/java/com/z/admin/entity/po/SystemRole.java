package com.z.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.z.admin.entity.po.base.BasePo;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统_角色
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
@Getter
@Setter
@TableName("system_role")
public class SystemRole extends BasePo {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型 0 普通角色 1超管
     */
    private Integer type;

    /**
     * 描述
     */
    private String description;
}
