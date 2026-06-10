package com.z.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.z.admin.security.UserDetail;
import com.z.admin.util.DataUtils;
import com.z.admin.util.LoginUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author tdsay
 * @description mybatis-plus自动填充handler
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String FIELD_CREATE_BY = "createBy";
    private static final String FIELD_CREATE_TIME = "createTime";
    private static final String FIELD_UPDATE_BY = "updateBy";
    private static final String FIELD_UPDATE_TIME = "updateTime";
    private static final String FIELD_DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = getCurrentUserId();
        LocalDateTime now = LocalDateTime.now();

        Object createBy = this.getFieldValByName(FIELD_CREATE_BY, metaObject);
        Object createTime = this.getFieldValByName(FIELD_CREATE_TIME, metaObject);
        Object deleted = this.getFieldValByName(FIELD_DELETED, metaObject);

        if (DataUtils.isEmpty(createBy)) {
            this.setFieldValByName(FIELD_CREATE_BY, userId, metaObject);
        }
        if (DataUtils.isEmpty(createTime)) {
            this.setFieldValByName(FIELD_CREATE_TIME, LocalDateTime.now(), metaObject);
        }
        if (DataUtils.isEmpty(deleted)) {
            this.setFieldValByName(FIELD_DELETED, false, metaObject);
        }

        Long updateBy = (Long) this.getFieldValByName(FIELD_UPDATE_BY, metaObject);
        Object updateTime = this.getFieldValByName(FIELD_UPDATE_TIME, metaObject);
        if (DataUtils.idIsNull(updateBy)) {
            this.setFieldValByName(FIELD_UPDATE_BY, userId, metaObject);
        }
        if (DataUtils.isEmpty(updateTime)) {
            this.setFieldValByName(FIELD_UPDATE_TIME, now, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = getCurrentUserId();
        this.setFieldValByName(FIELD_UPDATE_BY, userId, metaObject);
        this.setFieldValByName(FIELD_UPDATE_TIME, LocalDateTime.now(), metaObject);
    }

    /**
     * 获取当前登录用户的ID
     */
    private Long getCurrentUserId() {
        try {
            UserDetail userDetail = LoginUtil.getLoginUser();
            if (userDetail != null && userDetail.getUserLoginDto() != null) {
                return userDetail.getUserLoginDto().getId();
            }
        } catch (Exception e) {
            // 如果获取用户失败，返回默认值0
        }
        return 0L;
    }
}