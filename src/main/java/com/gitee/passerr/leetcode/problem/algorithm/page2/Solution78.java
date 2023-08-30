package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author xiehai
 * @date 2019/07/19 13:02
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution78 {
    // #region snippet
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        // 空集
        result.add(new ArrayList<>());
        if (length > 0) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        BiConsumer<Integer, List<Integer>> backtrack = new BiConsumer<Integer, List<Integer>>() {
            @Override
            public void accept(Integer len, List<Integer> list) {
                // 满足子集个数结束
                if (list.size() == len) {
                    result.add(new ArrayList<>(list));
                    return;
                }

                for (int num : nums) {
                    // 按照有小到大的顺序添加子集元素
                    if (!list.contains(num) && (list.isEmpty() || list.get(list.size() - 1) < num)) {
                        list.add(num);
                        this.accept(len, list);
                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
            }
        };

        // 子集元素个数依次回溯计算
        for (int i = 1; i < length; i++) {
            backtrack.accept(i, new ArrayList<>());
        }

        return result;
    }
    // #endregion snippet
}
