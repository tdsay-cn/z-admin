package com.z.admin.entity.form.system;

import lombok.Data;

/**
 * @author tdsay
 * @description 修改密码
 */
@Data
public class UserUpdatePwdForm {

    /**
     * 用户主键id
     */
    private Long id;

    /**
     * 密码
     */
    private String password;
}
