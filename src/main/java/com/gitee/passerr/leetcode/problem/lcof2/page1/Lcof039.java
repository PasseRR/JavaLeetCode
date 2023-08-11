package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定非负整数数组 heights，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * 1 <= heights.length <=10<sup>5</sup>
 * 0 <= heights[i] <= 10<sup>4</sup>
 * <p>
 * 注意：本题与主站 84题相同：https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * @author xiehai
 * @date 2022/01/11 18:22
 */
public class Lcof039 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, area = 0;
        // 若末尾不是0 补一个0 保证所有柱子都能被弹出
        if (heights[len - 1] != 0) {
            heights = Arrays.copyOfRange(heights, 0, len + 1);
            len = heights.length;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < len; i++) {
            // 若当前柱子高度大于栈顶 则计算栈顶两个柱子之间的面积
            while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                area = Integer.max(area, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            // 否则低柱子入栈
            stack.push(i);
        }

        return area;
    }
}
