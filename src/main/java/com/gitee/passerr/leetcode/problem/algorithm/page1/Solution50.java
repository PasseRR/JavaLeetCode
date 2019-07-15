package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.function.Function;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
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
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @author xiehai
 * @date 2019/07/10 20:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution29
 */
public class Solution50 {
    public double myPow(double x, int n) {
        Function<Integer, Double> pow = new Function<Integer, Double>() {
            @Override
            public Double apply(Integer p) {
                if (p == 0) {
                    return 1D;
                } else if (p == 1) {
                    return x;
                }
                // 递归、二分
                Double apply = this.apply(p / 2);

                return apply * apply * (p % 2 == 0 ? 1 : x);
            }
        };

        return n < 0 ? 1 / pow.apply(-n) : pow.apply(n);
    }

    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }

        // 二分
        double p = this.myPow(x, n / 2);
        if (n % 2 == 0) {
            return p * p;
        } else {
            return p * p * (n > 0 ? x : 1 / x);
        }
    }
}
