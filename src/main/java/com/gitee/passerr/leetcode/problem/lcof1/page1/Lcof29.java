package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * @author xiehai
 * @date 2020/07/04 15:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof29 {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        // 空数组处理
        if (rows == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int columns = matrix[0].length;
        int[] result = new int[rows * columns];

        // 圆圈个数 即循环次数 行列中取最小值
        int min = Math.min(rows, columns), index = 0;
        int circles = min / 2 + min % 2;
        for (int i = 0; i < circles; i++) {
            // 上行顺序
            for (int j = i; j < columns - i; j++) {
                result[index++] = matrix[i][j];
            }
            // 右列顺序
            for (int j = i + 1; j < rows - i; j++) {
                result[index++] = matrix[j][columns - i - 1];
            }
            // 如果是奇数行 最内层只有一行或一列
            if (i == circles - 1 && min % 2 == 1) {
                break;
            }
            // 下行逆序
            for (int j = columns - i - 2; j >= i; j--) {
                result[index++] = matrix[rows - i - 1][j];
            }
            // 左列逆序
            for (int j = rows - i - 2; j > i; j--) {
                result[index++] = matrix[j][i];
            }
        }

        return result;
    }
}
