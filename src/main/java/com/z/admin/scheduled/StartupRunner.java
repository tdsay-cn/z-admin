package com.z.admin.scheduled;

import com.z.admin.service.ISystemPermissionService;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.util.RedisUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tdsay
 * @description 服务启动依赖注入完成后执行逻辑
 */
@Component
@Slf4j
public class StartupRunner {

    @Resource
    ISystemPermissionService permissionService;
    @Resource
    ISystemRolePermissionService rolePermissionService;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 加载权限路由
     */
    @PostConstruct
    public void loadPermission() {
        this.permissionService.loadPermission();
    }

    /**
     * 加载角色权限路由
     */
    @PostConstruct
    public void loadRolePermission() {
        this.rolePermissionService.loadRolePermission();
    }
}
