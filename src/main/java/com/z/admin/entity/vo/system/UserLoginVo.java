package com.z.admin.entity.vo.system;

import com.z.admin.entity.dto.UserLoginDto;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tdsay
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserLoginVo extends BaseVo {

    /**
     * 用户名
     */
    private String username;

    /**
     * token
     */
    private String token;

    public UserLoginVo(UserLoginDto user) {
        BeanUtils.copyPropertiesIgnoreNull(user, this);
    }
}
