package com.z.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.z.admin.entity.po.base.BasePo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>
 * 商城_商品
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
@Getter
@Setter
@TableName("mall_goods")
public class MallGoods extends BasePo {

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
     * 描述
     */
    private String description;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 是否包邮 0不包邮 1包邮
     */
    private Boolean freeShipping;
}
