package com.z.admin.entity.param.system;

import com.z.admin.entity.param.base.BasePageParam;
import com.z.admin.entity.po.SystemRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色列表查询参数
 *
 * @author tdsay
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleQueryParam extends BasePageParam<SystemRole> {

}
