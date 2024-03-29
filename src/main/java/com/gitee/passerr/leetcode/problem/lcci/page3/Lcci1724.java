package com.gitee.passerr.leetcode.problem.lcci.page3;

/**
 * 给定一个正整数、负整数和 0 组成的 N × M矩阵，编写代码找出元素总和最大的子矩阵。
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。
 * 若有多个满足条件的子矩阵，返回任意一个均可。
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * 输入：
 * .[
 * .  [-1,0],
 * .  [0,-1]
 * .]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 * <p>
 * 说明：
 * 1 <= matrix.length, matrix[0].length <= 200
 * @author xiehai
 * @date 2021/06/21 17:11
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1724 {
    // #region snippet
    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        // 最大矩阵和
        int max = Integer.MIN_VALUE;
        // 最终结果
        int[] result = new int[4];


        // 构造列的前缀和
        // 前n行的和
        int[][] preSum = new int[rows + 1][columns];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 0; j < columns; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j];
            }
        }

        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                // 构造一维dp 表示为 tr到br之间行的和
                int[] dp = new int[columns];
                for (int i = 0; i < columns; i++) {
                    dp[i] = preSum[r2 + 1][i] - preSum[r1][i];
                }

                int c1 = 0, sum = Integer.MIN_VALUE;
                // 每列和累加
                for (int c2 = 0; c2 < columns; c2++) {
                    if (sum > 0) {
                        sum += dp[c2];
                    } else {
                        sum = dp[c2];
                        c1 = c2;
                    }

                    if (sum >= max) {
                        result[0] = r1;
                        result[1] = c1;
                        result[2] = r2;
                        result[3] = c2;
                        max = sum;
                    }
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
