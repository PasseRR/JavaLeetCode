package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>
 * 示例2:
 * 输入：n = 5
 * 输出：13
 * <p>
 * 提示:
 * n范围在[1, 1000000]之间
 * @author xiehai
 * @date 2020/06/23 09:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0801 {
    public int waysToStep(int n) {
        // 使用dp记录方式
        int[] dp = new int[4];
        // 初始化走法
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                // 3数和可能溢出 先两数取模
                int temp = ((dp[3] + dp[2]) % 1000000007 + dp[1]) % 1000000007;
                dp[1] = dp[2];
                dp[2] = dp[3];
                dp[3] = temp;
            }
        }

        return dp[Math.min(n, 3)];
    }
}
