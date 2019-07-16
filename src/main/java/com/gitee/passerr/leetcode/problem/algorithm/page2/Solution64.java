package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author xiehai
 * @date 2019/07/16 11:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i > 0 && j > 0) {
                    // 可以通过右移或者下移到达 取两者较小值与当前值相加
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    // 只能通过右移到达 两者相加
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j > 0) {
                    // 只能通过下移到达 两者相加
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else {
                    // 第一个位置(0, 0)初始化
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }
}
