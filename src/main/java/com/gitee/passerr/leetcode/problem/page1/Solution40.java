package com.gitee.passerr.leetcode.problem.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @author xiehai
 * @date 2019/07/09 11:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution39
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>(6);
        Arrays.sort(candidates);

        TrConsumer<Integer, Integer, List<Integer>> consumer = new TrConsumer<Integer, Integer, List<Integer>>() {
            @Override
            public void accept(Integer index, Integer sum, List<Integer> list) {
                int left = target - sum;
                if (left == 0) {
                    // 排序去重
                    List<Integer> temp = new ArrayList<>(list);
                    Collections.sort(temp);
                    result.add(temp);
                } else if (left > 0) {
                    // 还可以加数字
                    // 只能加小于等于剩余值的数字
                    for (int i = index; i < candidates.length && candidates[i] <= left; i++) {
                        int current = candidates[i];
                        list.add(current);
                        // 从下一个位置继续计算
                        this.accept(i + 1, sum + current, list);
                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
                // 剩余数字小于零 不满足条件
            }
        };

        consumer.accept(0, 0, new ArrayList<>());

        return new ArrayList<>(result);
    }

    private interface TrConsumer<T, U, P> {
        void accept(T t, U u, P p);
    }
}
