package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * |[
 * |  [1,   4,  7, 11, 15],
 * |  [2,   5,  8, 12, 19],
 * |  [3,   6,  9, 16, 22],
 * |  [10, 13, 14, 17, 24],
 * |  [18, 21, 23, 26, 30]
 * |]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * @author xiehai
 * @date 2020/08/10 11:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1009 {
    // #region snippet
    public boolean searchMatrix(int[][] matrix, int target) {
        // 倒叙行 升序列查找
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column <= matrix[0].length - 1) {
            // 找到目标值
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                // 若当前行列位置大于目标值 递减行
                row--;
            } else {
                // 若当前行列位置小于目标值 增加列
                column++;
            }
        }

        return false;
    }
}
    // #endregion snippet

