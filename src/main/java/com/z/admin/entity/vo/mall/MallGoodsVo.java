package com.z.admin.entity.vo.mall;

import com.z.admin.entity.po.MallGoods;
import com.z.admin.entity.vo.base.BaseVo;
import com.z.admin.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author tdsay
 * @description 商城-商品列表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MallGoodsVo extends BaseVo {

    /**
     * 商品名
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

    public MallGoodsVo(MallGoods goods) {
        BeanUtils.copyPropertiesIgnoreNull(goods, this);
    }

}
