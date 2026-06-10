package com.z.admin.controller;

import com.z.admin.entity.convert.PermissionConvert;
import com.z.admin.entity.dto.PermissionTreeDto;
import com.z.admin.entity.vo.base.Result;
import com.z.admin.entity.vo.system.PermissionTreeNodeVo;
import com.z.admin.entity.vo.system.RolePermissionTreeVo;
import com.z.admin.entity.vo.system.UserPermissionTreeVo;
import com.z.admin.service.ISystemPermissionService;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.service.ISystemUserPermissionService;
import com.z.admin.service.ISystemUserRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 权限
 *
 * @author tdsay
 * @description 权限
 */
@RestController
@RequestMapping("/system/permission")
public class PermissionController {

    @Resource
    private ISystemPermissionService systemPermissionService;
    @Resource
    private ISystemRolePermissionService rolePermissionService;
    @Resource
    private ISystemUserRoleService systemUserRoleService;
    @Resource
    private ISystemUserPermissionService systemUserPermissionService;
    @Resource
    private PermissionConvert permissionConvert;

    /**
     * 根据角色ID查询树形结构权限
     */
    @GetMapping("/role/tree")
    public Result<RolePermissionTreeVo> roleTree(@RequestParam(value = "roleId", required = false) Long roleId) {
        List<PermissionTreeDto> permissionTreeDto = this.systemPermissionService.queryPermissionTree();
        Set<Long> currentRolePermissionIdSet = this.rolePermissionService.queryPermissionByRoleId(roleId);
        List<PermissionTreeNodeVo> permissionTree = permissionConvert.toTreeNodeVoList(permissionTreeDto);
        return Result.success(new RolePermissionTreeVo(currentRolePermissionIdSet, permissionTree));
    }

    /**
     * 根据用户ID查询树形结构权限
     */
    @GetMapping("/user/tree")
    public Result<UserPermissionTreeVo> userTree(@RequestParam(value = "userId", required = false) Long userId) {
        // 权限树
        List<PermissionTreeDto> permissionTreeDto = this.systemPermissionService.queryPermissionTree();
        List<PermissionTreeNodeVo> permissionTree = permissionConvert.toTreeNodeVoList(permissionTreeDto);

        // 角色权限
        List<Long> roleIdList = this.systemUserRoleService.queryRoleByUserId(userId);
        Set<Long> currentRolePermissionIdSet = this.rolePermissionService.queryPermissionByRoleId(roleIdList);

        // 用户权限
        List<Long> currentUserPermissionIdSet = this.systemUserPermissionService.queryPermissionByUserId(userId);

        return Result.success(new UserPermissionTreeVo(currentRolePermissionIdSet, currentUserPermissionIdSet, permissionTree));
    }
}