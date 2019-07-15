package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @author xiehai
 * @date 2019/07/09 10:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>(4);
        Arrays.sort(candidates);

        BiConsumer<Integer, List<Integer>> consumer = new BiConsumer<Integer, List<Integer>>() {
            @Override
            public void accept(Integer sum, List<Integer> list) {
                int left = target - sum;
                if (left == 0) {
                    // 排序去重
                    List<Integer> temp = new ArrayList<>(list);
                    Collections.sort(temp);
                    result.add(temp);
                } else if (left > 0) {
                    // 还可以加数字
                    // 只能加小于等于剩余值的数字
                    for (int i = 0; i < candidates.length && candidates[i] <= left; i++) {
                        int current = candidates[i];
                        list.add(current);
                        this.accept(sum + current, list);
                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
                // 剩余数字小于零 不满足条件
            }
        };

        consumer.accept(0, new ArrayList<>());

        // 去掉重复
        return new ArrayList<>(result);
    }
}
