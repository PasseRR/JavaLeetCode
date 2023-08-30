package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @author xiehai
 * @date 2019/07/16 16:00
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution69 {
    // #region snippet
    public int mySqrt(int x) {
        // 二分法
        BiFunction<Integer, Integer, Integer> division = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer begin, Integer end) {
                // 出现小数的情况 向上取整
                if (begin > end) {
                    return end;
                }
                // 二分法
                int mid = begin + (end - begin) / 2;
                if (mid > x / mid) {
                    return this.apply(begin, mid - 1);
                } else if (mid < x / mid) {
                    return this.apply(mid + 1, end);
                }

                return mid;
            }
        };

        return x <= 1 ? x : division.apply(2, x);
    }

    public int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }
    // #endregion snippet
}
