package com.z.admin.entity.form.system;

import com.z.admin.entity.form.base.BaseForm;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.validator.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tdsay
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAddForm extends BaseForm<SystemUser> {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Phone
    private String mobile;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;
}
