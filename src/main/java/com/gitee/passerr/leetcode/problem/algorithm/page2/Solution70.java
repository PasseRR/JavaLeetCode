package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author xiehai
 * @date 2019/07/16 16:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution70 {
    public int climbStairs(int n) {
        // 递归tle 考虑使用dp
        int[] dp = new int[n];
        // 初始化1阶走法
        dp[0] = 1;
        if (n > 1) {
            // 初始化2阶走法
            dp[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public int climbStairs1(int n) {
        // 小于3 只有固定种方式爬
        // 大于3 有两种走法 第一步走一阶或者走两阶
        // 递归tle了
        return n < 3 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }
}
