package com.z.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.z.admin.entity.form.system.UserUpdatePwdForm;
import com.z.admin.entity.param.system.UserQueryParam;
import com.z.admin.entity.po.SystemUser;

/**
 * @author tdsay
 * @description SystemUserService
 */
public interface ISystemUserService extends IService<SystemUser> {

    IPage<SystemUser> query(UserQueryParam param);

    void updatePassWord(UserUpdatePwdForm form);

}
