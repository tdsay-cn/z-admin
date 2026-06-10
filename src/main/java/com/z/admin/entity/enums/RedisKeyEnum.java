package com.z.admin.entity.enums;

import lombok.Getter;

/**
 * @author tdsay
 * @description redisKey
 */
@Getter
public enum RedisKeyEnum {

    USER_INFO("userInfo:"),

    PERMISSION("permission:"),

    ROLE_PERMISSION("rolePermission:");

    private final String key;

    RedisKeyEnum(String key) {
        this.key = key;
    }

}
