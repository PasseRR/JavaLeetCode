package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.function.BiFunction;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * @author xiehai
 * @date 2020/07/04 14:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        BiFunction<Integer, Integer, Integer> backtrack = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer row, Integer column) {
                // 越界
                if (row >= m || row < 0 || column >= n || column < 0
                    // 已经访问过
                    || visited[row][column]
                    // 位数之和超出
                    || (row / 10 + row % 10 + column / 10 + column % 10 > k)) {
                    return 0;
                }

                // 访问标记
                visited[row][column] = true;

                return 1 + this.apply(row + 1, column) + this.apply(row - 1, column)
                    + this.apply(row, column + 1) + this.apply(row, column - 1);
            }
        };

        return backtrack.apply(0, 0);
    }
}
