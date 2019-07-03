package com.gitee.passerr.leetcode.problem.page1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @author xiehai
 * @date 2019/07/03 15:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        TrConsumer<Integer, Integer, String> recall = new TrConsumer<Integer, Integer, String>() {
            @Override
            public void accept(Integer left, Integer right, String s) {
                // left < right 保证括号合法
                // left < n 隐含包括 right < n 保证括号个数
                if (left < right || left > n) {
                    return;
                }

                // 满足括号个数结束回溯
                if (left.equals(right) && left == n) {
                    result.add(s);
                    return;
                }

                // 左右两边各加一个括号进行回溯
                this.accept(left + 1, right, s + "(");
                this.accept(left, right + 1, s + ")");
            }
        };

        if (n > 0) {
            recall.accept(0, 0, "");
        }

        return new ArrayList<>(result);
    }

    private interface TrConsumer<T, U, P> {
        void accept(T t, U u, P p);
    }
}
