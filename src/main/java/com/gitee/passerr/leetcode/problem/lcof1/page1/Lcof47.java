package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * 输入:
 * |[
 * |  [1,3,1],
 * |  [1,5,1],
 * |  [4,2,1]
 * |]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * @author xiehai
 * @date 2020/07/14 13:11
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof47 {
    // #region snippet
    public int maxValue(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        // 初始化第一行及第一列的数据
        for (int i = 1; i < columns; i++) {
            dp[0][i] += grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }
    // #endregion snippet
}
