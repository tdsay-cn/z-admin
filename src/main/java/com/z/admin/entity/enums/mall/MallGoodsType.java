package com.z.admin.entity.enums.mall;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tdsay
 * @description 商品类型
 */
@Getter
public enum MallGoodsType {

    /**
     * 数码
     */
    ELECTRONICS(1,"数码"),

    /**
     * 服装
     */
    CLOTHING(2,"服装"),

    /**
     * 食品
     */
    FOOD(3,"食品");


    private final Integer id;

    private final String desc;

    MallGoodsType(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private static final Map<Integer, String> ID_TO_DESC_MAP = new HashMap<>();

    static {
        for (MallGoodsType type : values()) {
            ID_TO_DESC_MAP.put(type.getId(), type.getDesc());
        }
    }

    /**
     * 根据 id 获取描述信息
     * @param id 类型id
     * @return 描述文本，如果 id 不存在则返回 空字符串
     */
    public static String getDescById(Integer id) {
        return ID_TO_DESC_MAP.getOrDefault(id,"");
    }
}
