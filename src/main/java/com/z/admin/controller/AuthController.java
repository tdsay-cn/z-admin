package com.z.admin.controller;

import com.z.admin.entity.dto.UserLoginDto;
import com.z.admin.entity.form.system.UserLoginForm;
import com.z.admin.entity.vo.base.Result;
import com.z.admin.entity.vo.system.UserInfoVo;
import com.z.admin.entity.vo.system.UserLoginVo;
import com.z.admin.security.UserDetail;
import com.z.admin.service.ISystemAuthService;
import com.z.admin.util.BeanUtils;
import com.z.admin.util.LoginUtil;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 认证鉴权
 *
 * @author tdsay
 * @description 登录相关
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    ISystemAuthService systemAuthService;

    /**
     * 登录
     *
     * @param form 参数
     */
    @PostMapping("/login")
    public Result<UserLoginVo> login(@Valid @RequestBody UserLoginForm form) {
        // 调用登录方法
        UserLoginDto userLoginDto = systemAuthService.login(form);
        return Result.success(new UserLoginVo(userLoginDto));
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public Result<UserLoginVo> logout() {
        this.systemAuthService.logout();
        return Result.success();
    }

    /**
     * 查询用户信息
     */
    @GetMapping("/info")
    public Result<UserInfoVo> info() {
        // 基本信息
        UserLoginDto userLoginDto = LoginUtil.getLoginUser().getUserLoginDto();
        UserInfoVo userInfoVo = BeanUtils.copyProperties(userLoginDto, UserInfoVo.class);

        // 权限处理
        UserDetail userDetail = LoginUtil.getLoginUser();
        Collection<GrantedAuthority> authorities = userDetail.getAuthorities();
        List<Long> permissionList = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            permissionList.add(Long.parseLong(authority.getAuthority()));
        }
        userInfoVo.setPermissionList(permissionList);
        return Result.success(userInfoVo);
    }
}
