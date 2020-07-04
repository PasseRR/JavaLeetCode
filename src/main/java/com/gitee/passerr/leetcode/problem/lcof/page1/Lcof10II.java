package com.gitee.passerr.leetcode.problem.lcof.page1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>
 * 提示：
 * 0 <= n <= 100
 * @author xiehai
 * @date 2020/07/04 14:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof10II {
    public int numWays(int n) {
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                int temp = (dp[2] + dp[1]) % 1000000007;
                dp[1] = dp[2];
                dp[2] = temp;
            }
        }

        return dp[Integer.min(n, 2)];
    }
}
