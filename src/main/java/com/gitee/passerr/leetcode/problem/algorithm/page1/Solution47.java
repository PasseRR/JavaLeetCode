package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * @author xiehai
 * @date 2019/07/10 19:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution47 {
    // #region snippet
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> indexes) {
                if (indexes.size() == nums.length) {
                    // 将索引转为数值
                    result.add(indexes.stream().map(index -> nums[index]).collect(Collectors.toList()));
                    return;
                }

                for (int i = 0; i < nums.length; i++) {
                    // 数值可能会重复 记录索引
                    if (!indexes.contains(i)) {
                        indexes.add(i);
                        this.accept(indexes);
                        // 回溯
                        indexes.remove(indexes.size() - 1);
                    }
                }
            }
        };

        // 考虑数组为空的情况
        if (nums.length > 0) {
            consumer.accept(new ArrayList<>());
        }

        return new ArrayList<>(result);
    }
    // #endregion snippet
}
