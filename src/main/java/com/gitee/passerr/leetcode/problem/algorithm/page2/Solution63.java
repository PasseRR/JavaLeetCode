package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * @author xiehai
 * @date 2019/07/16 11:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution63
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        // 动态规划
        int[][] dp = new int[rows][columns];
        // 根据障碍物初始化第一个位置
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 排除障碍物
                if (obstacleGrid[i][j] != 1) {
                    // 累加左边
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }

                    // 累加上边
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }
}
