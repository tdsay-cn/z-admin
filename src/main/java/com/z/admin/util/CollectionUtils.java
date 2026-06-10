package com.z.admin.util;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tdsay
 * @description 集合工具类
 */
public class CollectionUtils {

    /**
     * 计算需要删除的ID集合
     *
     * @param oldSet 旧的ID集合
     * @param newSet 新的ID集合
     * @return 需要删除的ID集合
     */
    public static Set<Long> computeToRemove(Set<Long> oldSet, Set<Long> newSet) {
        return oldSet.stream()
                .filter(id -> !newSet.contains(id))
                .collect(Collectors.toSet());
    }

    /**
     * 计算需要新增的ID集合
     *
     * @param oldSet 旧的ID集合
     * @param newSet 新的ID集合
     * @return 需要新增的ID集合
     */
    public static Set<Long> computeToAdd(Set<Long> oldSet, Set<Long> newSet) {
        return newSet.stream()
                .filter(id -> !oldSet.contains(id))
                .collect(Collectors.toSet());
    }
}
