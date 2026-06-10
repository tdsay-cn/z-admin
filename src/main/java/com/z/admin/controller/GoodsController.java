package com.z.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.z.admin.entity.enums.mall.MallGoodsStatus;
import com.z.admin.entity.enums.mall.MallGoodsType;
import com.z.admin.entity.excel.ExportData;
import com.z.admin.entity.excel.GoodsExportVo;
import com.z.admin.entity.form.system.GoodsUpdateForm;
import com.z.admin.entity.param.mall.GoodsQueryParam;
import com.z.admin.entity.po.MallGoods;
import com.z.admin.entity.vo.base.Result;
import com.z.admin.entity.vo.mall.MallGoodsDetailVo;
import com.z.admin.entity.vo.mall.MallGoodsVo;
import com.z.admin.service.IMallGoodsService;
import com.z.admin.util.BeanUtils;
import com.z.admin.util.excel.EasyExcelUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商城-商品管理
 *
 * @author tdsay
 * @description 商城商品相关
 */
@RestController
@RequestMapping("/mall/goods")
public class GoodsController {

    @Resource
    IMallGoodsService mallGoodsService;

    /**
     * 商品列表
     *
     * @param param 查询参数
     */
    @PostMapping("/list")
    public Result<IPage<MallGoodsVo>> login(@RequestBody GoodsQueryParam param) {
        IPage<MallGoods> iPage = this.mallGoodsService.query(param);
        return Result.success(iPage.convert(MallGoodsVo::new));
    }

    /**
     * 商品详情
     *
     * @param id 商品id
     */
    @GetMapping("/{id}")
    public Result<MallGoodsDetailVo> detail(@PathVariable("id") Long id) {
        MallGoods mallGoods = this.mallGoodsService.getById(id);
        return Result.success(new MallGoodsDetailVo(mallGoods));
    }

    /**
     * 修改商品信息
     *
     * @param form 商品信息
     */
    @PutMapping
    public Result<?> update(@Valid @RequestBody GoodsUpdateForm form) {
        this.mallGoodsService.updateById(form.toPo());
        return Result.success();
    }

    /**
     * 商品导出
     *
     * @param param 查询参数
     */
    @PostMapping("/export")
    public void export(@RequestBody GoodsQueryParam param, HttpServletResponse response) throws Exception {
        List<MallGoods> goodsList = this.mallGoodsService.queryForExport(param);
        List<GoodsExportVo> exportList = new ArrayList<>();
        for (MallGoods goods : goodsList) {
            GoodsExportVo vo = new GoodsExportVo();
            BeanUtils.copyPropertiesIgnoreNull(goods, vo);
            vo.setTypeName(MallGoodsType.getDescById(goods.getType()));
            vo.setStatusName(MallGoodsStatus.getDescById(goods.getStatus()));
            vo.setFreeShippingName(goods.getFreeShipping() ? "包邮" : "不包邮");
            exportList.add(vo);
        }
        List<ExportData<?>> dataList = new ArrayList<>();
        dataList.add(new ExportData<>("商品列表", GoodsExportVo.class, exportList));
        EasyExcelUtil.exportData(response, dataList, "商品导出");
    }

}
