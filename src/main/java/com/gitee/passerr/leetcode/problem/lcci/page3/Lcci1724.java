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

        for (int tr = 0; tr < rows; tr++) {
            for (int br = tr; br < rows; br++) {
                // 构造一维dp 表示为 tr到br之间行的和
                int[] dp = new int[columns];
                for (int i = 0; i < columns; i++) {
                    dp[i] = preSum[br + 1][i] - preSum[tr][i];
                }

                int tc = 0, sum = Integer.MIN_VALUE;
                // 每列和累加
                for (int bc = 0; bc < columns; bc++) {
                    if (sum > 0) {
                        sum += dp[bc];
                    } else {
                        sum = dp[bc];
                        tc = bc;
                    }

                    if (sum >= max) {
                        result[0] = tr;
                        result[1] = tc;
                        result[2] = br;
                        result[3] = bc;
                        max = sum;
                    }
                }
            }
        }

        return result;
    }
}
