package com.z.admin.service;

import com.z.admin.entity.dto.UserLoginDto;
import com.z.admin.entity.form.system.UserLoginForm;
import com.z.admin.security.UserDetail;


/**
 * @author tdsay
 */
public interface ISystemAuthService {

    UserLoginDto login(UserLoginForm form);

    void logout();

    UserDetail loadUserByCache(String username);

    void logout(String userName);

    void logout(Long userId);
}
