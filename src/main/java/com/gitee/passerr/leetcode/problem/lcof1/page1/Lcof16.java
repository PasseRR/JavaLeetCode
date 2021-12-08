package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.function.Function;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * @author xiehai
 * @date 2020/07/04 14:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof16 {
    public double myPow(double x, int n) {
        Function<Integer, Double> recursion = new Function<Integer, Double>() {
            @Override
            public Double apply(Integer pow) {
                if (pow == 0) {
                    return 1D;
                } else if (pow == 1) {
                    return x;
                }

                // 二分
                Double cut = this.apply(pow / 2);

                // 乘以二分的余数
                return cut * cut * this.apply(pow & 1);
            }
        };

        return n < 0 ? 1 / recursion.apply(-n) : recursion.apply(n);
    }
}
