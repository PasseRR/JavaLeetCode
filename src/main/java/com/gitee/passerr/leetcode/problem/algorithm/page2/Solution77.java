package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @author xiehai
 * @date 2019/07/19 12:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // 回溯组合
        BiConsumer<Integer, List<Integer>> backtrack = new BiConsumer<Integer, List<Integer>>() {
            @Override
            public void accept(Integer from, List<Integer> list) {
                if (list.size() == k) {
                    result.add(new ArrayList<>(list));
                    return;
                }

                // 从起始值开始遍历
                for (int i = from; i <= n; i++) {
                    list.add(i);
                    // 保证列表元素为递增
                    this.accept(i + 1, list);
                    // 回溯 移除最后一个元素
                    list.remove(list.size() - 1);
                }
            }
        };

        // 传入起始值 下一个元素必须比起始值大
        backtrack.accept(1, new ArrayList<>());

        return result;
    }
}
