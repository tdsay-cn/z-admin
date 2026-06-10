package com.z.admin.entity.enums.system;

import lombok.Getter;

/**
 * @author tdsay
 * @description 角色类型
 */
@Getter
public enum SystemRoleType {

    /**
     * 普通角色
     */
    NORMAL(0),

    /**
     * 超管
     */
    SUPPER(1);


    private final Integer id;

    SystemRoleType(Integer id) {
        this.id = id;
    }
}
