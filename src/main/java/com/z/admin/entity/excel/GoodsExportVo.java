package com.z.admin.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author tdsay
 * @description 商品导出实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsExportVo {

    @ExcelProperty("商品名称")
    private String name;

    @ExcelProperty("商品类型")
    private String typeName;

    @ExcelProperty("价格")
    private BigDecimal price;

    @ExcelProperty("库存")
    private Integer stock;

    @ExcelProperty("状态")
    private String statusName;

    @ExcelProperty("描述")
    private String description;

    @ExcelProperty("品牌")
    private String brand;

    @ExcelProperty("是否包邮")
    private String freeShippingName;
}