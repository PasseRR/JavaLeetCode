package com.gitee.passerr.leetcode.problem.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author xiehai
 * @date 2019/07/10 19:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> list) {
                // 长度相同 已经排列完成
                if (list.size() == nums.length) {
                    result.add(new ArrayList<>(list));
                    return;
                }

                for (int num : nums) {
                    if (!list.contains(num)) {
                        list.add(num);
                        this.accept(list);
                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
            }
        };

        // 排除数组为空的时候
        if (nums.length > 0) {
            consumer.accept(new ArrayList<>());
        }

        return result;
    }
}
