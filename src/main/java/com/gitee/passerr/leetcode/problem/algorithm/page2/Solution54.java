package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author xiehai
 * @date 2019/07/12 13:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        // 空数组处理
        if (rows == 0 || matrix[0].length == 0) {
            return result;
        }
        int columns = matrix[0].length;

        // 圆圈个数 即循环次数 行列中取最小值
        int min = Math.min(rows, columns);
        int circles = min / 2 + min % 2;
        for (int i = 0; i < circles; i++) {
            // 上行顺序
            for (int j = i; j < columns - i; j++) {
                result.add(matrix[i][j]);
            }
            // 右列顺序
            for (int j = i + 1; j < rows - i; j++) {
                result.add(matrix[j][columns - i - 1]);
            }
            // 如果是奇数行 最内层只有一行或一列
            if (i == circles - 1 && min % 2 == 1) {
                break;
            }
            // 下行逆序
            for (int j = columns - i - 2; j >= i; j--) {
                result.add(matrix[rows - i - 1][j]);
            }
            // 左列逆序
            for (int j = rows - i - 2; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }

        return result;
    }
}
