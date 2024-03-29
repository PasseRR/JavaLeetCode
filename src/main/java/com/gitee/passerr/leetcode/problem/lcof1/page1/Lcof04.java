package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
 * <p>
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * @author xiehai
 * @date 2020/07/04 13:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof04 {
    // #region snippet
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int columns = matrix[0].length;
        // 第一行按列倒叙查找
        for (int i = columns - 1; i >= 0; i--) {
            // 定位列
            if (target >= matrix[0][i]) {
                // 从找到的列 按行升序查找
                for (int[] nums : matrix) {
                    if (nums[i] == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // #endregion snippet
}
