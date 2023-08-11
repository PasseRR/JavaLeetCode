package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Stack;

/**
 * 给定一个由0 和 1组成的矩阵 matrix，找出只包含 1 的最大矩形，并返回其面积。
 * 注意：此题 matrix输入格式为一维 01 字符串数组。
 * <p>
 * 示例 1：
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：matrix = ["0"]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：matrix = ["1"]
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：matrix = ["00"]
 * 输出：0
 * <p>
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * 注意：本题与主站 85 题相同（输入参数格式不同）：https://leetcode.cn/problems/maximal-rectangle/
 * @author xiehai
 * @date 2022/01/14 15:20
 */
public class Lcof040 {
    public int maximalRectangle(String[] matrix) {
        int area = 0, rows = matrix.length;
        if (rows == 0) {
            return area;
        }

        int cols = matrix[0].length();
        // 最后一列补0 保证所有数字出栈
        int[][] dp = new int[rows][cols + 1];
        // 初始化垂直方向1的个数
        // 类似39题，倒叙求矩阵中柱子最大面积
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i].charAt(j) == '1') {
                    dp[i][j] = (i == 0 ? 0 : dp[i - 1][j]) + 1;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = rows - 1; i >= 0; i--) {
            stack.push(-1);
            for (int j = 0; j < cols + 1; j++) {
                while (stack.size() > 1 && dp[i][stack.peek()] >= dp[i][j]) {
                    area = Integer.max(area, dp[i][stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            stack.clear();
        }

        return area;
    }
}
