package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * @author xiehai
 * @date 2019/07/19 17:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution84 {
    // #region snippet
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
    // #endregion snippet
}
