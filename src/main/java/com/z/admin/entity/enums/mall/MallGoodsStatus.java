package com.z.admin.entity.enums.mall;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tdsay
 * @description 商品状态
 */
@Getter
public enum MallGoodsStatus {

    /**
     * 待审核
     */
    PENDING_REVIEW(0,"待审核"),

    /**
     * 上架
     */
    ON_SALE(1,"上架"),

    /**
     * 下架
     */
    OFF_SALE(2,"下架");

    private final Integer id;

    private final String desc;

    MallGoodsStatus(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private static final Map<Integer, String> ID_TO_DESC_MAP = new HashMap<>();

    static {
        for (MallGoodsStatus status : values()) {
            ID_TO_DESC_MAP.put(status.getId(), status.getDesc());
        }
    }

    /**
     * 根据 id 获取描述信息
     * @param id 状态id
     * @return 描述文本，如果 id 不存在则返回 空字符串
     */
    public static String getDescById(Integer id) {
        return ID_TO_DESC_MAP.getOrDefault(id,"");
    }

}
