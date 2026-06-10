package com.z.admin.entity.enums.system;

import lombok.Getter;

/**
 * @author tdsay
 * @description 用户类型
 */
@Getter
public enum SystemUserType {

    /**
     * 普通角色
     */
    NORMAL(0),

    /**
     * 超管
     */
    SUPPER(1);


    private final Integer id;

    SystemUserType(Integer id) {
        this.id = id;
    }
}
