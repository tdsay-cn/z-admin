package com.z.admin.entity.param.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.z.admin.entity.po.base.BasePo;
import lombok.Data;

/**
 * @author tdsay
 * @description
 */
@Data
public class BasePageParam<T extends BasePo> {

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页显示数量
     */
    private Integer pageSize = 10;

    /**
     * 从form中获取page参数，用于分页查询参数
     * 默认不使用mybatis-plus的count，因为会根据查询语句去生成对应的count的sql，这步转换非常影响性能！
     */
    public Page<T> getPage() {
        Page<T> page = new Page<>(this.getCurrentPage(), this.getPageSize(), false);
        // 按理说配置searchCount是false，count语句优化应该不用管，但是实测下来还是有点点差别，索性就多配一下
        page.setOptimizeCountSql(false);
        return page;
    }
}
