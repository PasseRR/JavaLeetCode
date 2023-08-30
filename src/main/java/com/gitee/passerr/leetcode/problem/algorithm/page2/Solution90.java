package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * @author xiehai
 * @date 2019/07/24 16:01
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution78
 */
public class Solution90 {
    // #region snippet
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;
        // 空集
        result.add(new ArrayList<>());
        if (length > 0) {
            // 全集
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        BiConsumer<Integer, List<Integer>> backtrack = new BiConsumer<Integer, List<Integer>>() {
            @Override
            public void accept(Integer len, List<Integer> list) {
                // 满足子集个数结束
                if (list.size() == len) {
                    // 排序保证唯一性
                    result.add(list.stream().map(it -> nums[it]).sorted().collect(Collectors.toList()));
                    return;
                }

                for (int i = list.isEmpty() ? 0 : list.get(list.size() - 1) + 1; i < length; i++) {
                    // 根据索引判断是否已经使用该元素
                    // 保证按照索引递增
                    list.add(i);
                    this.accept(len, list);
                    // 回溯
                    list.remove(list.size() - 1);
                }
            }
        };

        // 子集元素个数依次回溯计算
        for (int i = 1; i < length; i++) {
            backtrack.accept(i, new ArrayList<>());
        }

        return new ArrayList<>(result);
    }
    // #endregion snippet
}
