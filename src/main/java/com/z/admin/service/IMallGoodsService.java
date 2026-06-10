package com.z.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.z.admin.entity.param.mall.GoodsQueryParam;
import com.z.admin.entity.po.MallGoods;

import java.util.List;

/**
 * <p>
 * 商城_商品 服务类
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
public interface IMallGoodsService extends IService<MallGoods> {

    /**
     * 查询商品列表
     */
    IPage<MallGoods> query(GoodsQueryParam param);

    /**
     * 查询商品列表用于导出
     */
    List<MallGoods> queryForExport(GoodsQueryParam param);

}
