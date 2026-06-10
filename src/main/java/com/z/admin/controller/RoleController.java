package com.z.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.z.admin.entity.form.system.RoleForm;
import com.z.admin.entity.form.system.RolePermissionForm;
import com.z.admin.entity.form.system.RoleUpdateForm;
import com.z.admin.entity.param.system.RoleQueryParam;
import com.z.admin.entity.po.SystemRole;
import com.z.admin.entity.vo.base.Result;
import com.z.admin.entity.vo.system.RoleInfoVo;
import com.z.admin.entity.vo.system.RoleVo;
import com.z.admin.service.ISystemRolePermissionService;
import com.z.admin.service.ISystemRoleService;
import com.z.admin.util.BeanUtils;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 *
 * @author tdsay
 * @description 角色管理
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Resource
    ISystemRoleService systemRoleService;
    @Resource
    ISystemRolePermissionService rolePermissionService;

    /**
     * 角色列表
     */
    @PostMapping("/list")
    public Result<IPage<RoleVo>> list(@RequestBody RoleQueryParam param) {
        IPage<SystemRole> iPage = systemRoleService.query(param);
        return Result.success(iPage.convert(RoleVo::new));
    }

    /**
     * 修改角色基本信息
     */
    @PutMapping
    public Result<?> update(@RequestBody RoleUpdateForm form) {

        return Result.success();
    }

    /**
     * 修改角色权限
     */
    @PutMapping("/permission")
    public Result<?> update(@Valid @RequestBody RolePermissionForm form) {
        rolePermissionService.updatePermission(form);
        return Result.success();
    }

    /**
     * 增加角色
     */
    @PostMapping("/add")
    public Result<?> add(@Valid @RequestBody RoleForm form) {
        this.systemRoleService.save(form.toPo());
        return Result.success();
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable("id") Long id) {
        this.systemRoleService.delete(id);
        return Result.success();
    }

    /**
     * 全部角色
     */
    @GetMapping("/all")
    public Result<List<RoleInfoVo>> list() {
        List<SystemRole> roleList = this.systemRoleService.all();
        List<RoleInfoVo> result = BeanUtils.copyListProperties(roleList, RoleInfoVo::new);
        return Result.success(result);
    }
}
