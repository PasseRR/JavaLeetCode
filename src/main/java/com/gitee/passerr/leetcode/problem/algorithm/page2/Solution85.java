package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * @author xiehai
 * @date 2019/07/22 13:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rows, columns;
        if ((rows = matrix.length) == 0 || (columns = matrix[0].length) == 0) {
            return 0;
        }
        // 高度计算
        int[][] heights = new int[rows][columns];
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 只计算为1的部分
                if (matrix[i][j] == '1') {
                    // 累加上一行同一列的高度
                    heights[i][j] = i - 1 < 0 ? 1 : heights[i - 1][j] + 1;
                }
                // 否则 该点位面积为0
            }
            // 按照是否是1转换为高度数组
            // 列值累加 当前列为0 则高度为0
            int rowMax = this.largestRectangleArea(heights[i]);
            if (rowMax > result) {
                result = rowMax;
            }
        }

        return result;
    }

    /**
     * 计算一行的最大面积
     * @param heights 高度
     * @return 最大面积
     * @see Solution84#largestRectangleArea(int[])
     */
    public int largestRectangleArea(int[] heights) {
        // 考虑使用二分法
        BiFunction<Integer, Integer, Integer> divide = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                // 超过区间
                if (left > right) {
                    return 0;
                }
                // 找到当前区间最小值索引
                int mid = left;
                for (int i = left + 1; i <= right; i++) {
                    if (heights[i] < heights[mid]) {
                        mid = i;
                    }
                }

                return
                    Math.max(
                        // 计算当前区间最大面积
                        (right - left + 1) * heights[mid],
                        // 计算左右两边最大面积
                        Math.max(
                            this.apply(left, mid - 1),
                            this.apply(mid + 1, right)
                        )
                    );
            }
        };

        int length = heights.length;

        return length == 0 ? 0 : divide.apply(0, length - 1);
    }
}
