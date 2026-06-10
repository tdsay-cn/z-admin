package com.z.admin.entity.vo.mall;

import com.z.admin.entity.po.MallGoods;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author tdsay
 * @description 商城-商品详情
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MallGoodsDetailVo extends BaseVo {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品类型 1数码 2服装 3食品
     */
    private Integer type;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 状态 0待审核 1上架  2下架
     */
    private Integer status;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 是否包邮
     */
    private Boolean freeShipping;

    public MallGoodsDetailVo(MallGoods goods) {
        BeanUtils.copyPropertiesIgnoreNull(goods, this);
    }
}
