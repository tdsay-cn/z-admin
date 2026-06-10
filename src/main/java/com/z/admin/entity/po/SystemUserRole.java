package com.z.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.z.admin.entity.po.base.BasePo;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统_用户角色关联
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
@Getter
@Setter
@TableName("system_user_role")
public class SystemUserRole extends BasePo {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;
}
