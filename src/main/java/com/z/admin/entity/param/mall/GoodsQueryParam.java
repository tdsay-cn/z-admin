package com.z.admin.entity.param.mall;

import com.z.admin.entity.param.base.BasePageParam;
import com.z.admin.entity.po.MallGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品列表查询参数
 *
 * @author tdsay
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsQueryParam extends BasePageParam<MallGoods> {

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品类型
     */
    private Integer type;

}
