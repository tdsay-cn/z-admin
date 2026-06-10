package com.z.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.admin.dao.MallGoodsMapper;
import com.z.admin.entity.param.mall.GoodsQueryParam;
import com.z.admin.entity.po.MallGoods;
import com.z.admin.service.IMallGoodsService;
import com.z.admin.util.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商城_商品 服务实现类
 * </p>
 *
 * @author system
 * @since 2026-06-06
 */
@Service
@Slf4j
public class MallGoodsService extends ServiceImpl<MallGoodsMapper, MallGoods> implements IMallGoodsService {

    @Override
    public IPage<MallGoods> query(GoodsQueryParam param) {
        // 处理查询条件
        LambdaQueryWrapper<MallGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DataUtils.isNotEmpty(param.getType()), MallGoods::getType, param.getType());
        wrapper.like(DataUtils.isNotEmpty(param.getName()), MallGoods::getName, param.getName());

        // 处理count
        Page<MallGoods> page = param.getPage();
        Page<MallGoods> ipage = this.page(page, wrapper);
        ipage.setTotal(this.count(wrapper));

        return ipage;
    }

    @Override
    public List<MallGoods> queryForExport(GoodsQueryParam param) {
        LambdaQueryWrapper<MallGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DataUtils.isNotEmpty(param.getType()), MallGoods::getType, param.getType());
        wrapper.like(DataUtils.isNotEmpty(param.getName()), MallGoods::getName, param.getName());
        return this.list(wrapper);
    }

}
