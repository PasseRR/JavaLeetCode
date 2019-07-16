package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * @author xiehai
 * @date 2019/07/16 10:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        // 动态规划
        int[][] dp = new int[m][n];
        // 第一个位置为可达位置
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    // 累加左边总数
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    // 累加上边总数
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
