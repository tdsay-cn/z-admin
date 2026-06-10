package com.z.admin.entity.enums.system;

import lombok.Getter;

/**
 * @author tdsay
 * @description 操作权限类型
 */
@Getter
public enum SystemPermissionType {

    /**
     * 页面权限
     */
    PAGE(1),

    /**
     * 操作权限
     */
    OPERATE(2);

    private final Integer id;

    SystemPermissionType(Integer id) {
        this.id = id;
    }
}
