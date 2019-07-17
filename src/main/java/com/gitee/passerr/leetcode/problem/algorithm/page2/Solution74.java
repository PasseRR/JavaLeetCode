package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * @author xiehai
 * @date 2019/07/17 15:01
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows, columns;
        // 空数组兼容
        if ((rows = matrix.length) == 0 || (columns = matrix[0].length) == 0) {
            return false;
        }

        int rowIndex = 0, columnIndex = columns - 1;
        while (rowIndex < rows && columnIndex >= 0) {
            if (matrix[rowIndex][columnIndex] == target) {
                return true;
            } else if (matrix[rowIndex][columnIndex] < target) {
                // 通过最后一个数字判定所属行
                rowIndex++;
            } else {
                // 找到数据航 依次判断是否和target一致
                columnIndex--;
            }
        }

        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int rows, columns;
        // 空数组兼容
        if ((rows = matrix.length) == 0 || (columns = matrix[0].length) == 0) {
            return false;
        }
        // 二分查找target在矩阵中的行数
        BiFunction<Integer, Integer, Integer> findRow = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer start, Integer end) {
                if (start > end) {
                    return -1;
                }

                int middle = (end + start) / 2;
                if (matrix[middle][0] <= target && matrix[middle][columns - 1] >= target) {
                    return middle;
                } else if (matrix[middle][0] > target) {
                    return this.apply(start, middle - 1);
                } else {
                    return this.apply(middle + 1, end);
                }
            }
        };

        // 二分查找target所在列
        BiFunction<Integer, Integer, Boolean> findColumn = new BiFunction<Integer, Integer, Boolean>() {
            private boolean fetchRow = false;
            private int row = -1;

            @Override
            public Boolean apply(Integer start, Integer end) {
                if (!fetchRow) {
                    fetchRow = true;
                    row = findRow.apply(0, rows - 1);
                    if (row == -1) {
                        return false;
                    }
                }

                if (start > end) {
                    return false;
                }

                int middle = (end + start) / 2;
                if (matrix[row][middle] == target) {
                    return true;
                } else if (matrix[row][middle] < target) {
                    return this.apply(middle + 1, end);
                } else {
                    return this.apply(start, middle - 1);
                }
            }
        };

        return findColumn.apply(0, columns - 1);
    }
}
