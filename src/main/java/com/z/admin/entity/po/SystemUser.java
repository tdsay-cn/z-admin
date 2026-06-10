package com.z.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.z.admin.entity.po.base.BasePo;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统_用户
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
@Getter
@Setter
@TableName("system_user")
public class SystemUser extends BasePo {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String nickName;

    /**
     * 用户类型 0普通用户 1超管
     */
    private Integer type;

    /**
     * 是否禁用
     */
    private Boolean disabled;
}
