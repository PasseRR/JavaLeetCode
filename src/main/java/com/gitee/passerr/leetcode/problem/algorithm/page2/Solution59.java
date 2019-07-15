package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * @author xiehai
 * @date 2019/07/15 13:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution54
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int circles = n / 2 + n % 2, num = 1;
        for (int i = 0; i < circles; i++) {
            // 上行
            for (int j = i; j < n - i; j++) {
                result[i][j] = num++;
            }
            // 右列
            for (int j = i + 1; j < n - i; j++) {
                result[j][n - i - 1] = num++;
            }
            // 如果是奇数行 最内层只有一行或一列
            if (i == circles - 1 && n % 2 == 1) {
                break;
            }
            // 下行
            for (int j = n - i - 2; j >= i; j--) {
                result[n - i - 1][j] = num++;
            }
            // 左列
            for (int j = n - i - 2; j > i; j--) {
                result[j][i] = num++;
            }
        }

        return result;
    }
}
