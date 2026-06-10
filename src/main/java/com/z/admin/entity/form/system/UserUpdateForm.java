package com.z.admin.entity.form.system;

import com.z.admin.entity.form.base.BaseForm;
import com.z.admin.entity.po.SystemUser;
import com.z.admin.validator.Phone;
import com.z.admin.validator.ValidId;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tdsay
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateForm extends BaseForm<SystemUser> {

    /**
     * 用户主键id
     */
    @ValidId
    private Long id;

    /**
     * 手机号
     */
    @Phone
    private String mobile;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 昵称
     */
    private String nickName;
}
