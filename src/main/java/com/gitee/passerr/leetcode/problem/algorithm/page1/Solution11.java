package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @author xiehai
 * @date 2019/07/02 14:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, length = height.length; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // 取最短的边作为容器的高度
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }
}
