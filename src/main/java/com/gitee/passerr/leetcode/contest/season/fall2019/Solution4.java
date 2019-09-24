package com.gitee.passerr.leetcode.contest.season.fall2019;

import java.util.function.BiConsumer;

/**
 * @author xiehai1
 * @date 2019/09/24 22:13
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution4 {
    public int domino(int n, int m, int[][] broken) {
        // 初始化多米诺牌
        boolean[][] dominoes = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dominoes[i][j] = true;
            }
        }

        //初始化故障
        for (int[] b : broken) {
            dominoes[b[0]][b[1]] = false;
        }

        // 格子数量
        int maxSteps = m * n;
        // 结果
        int[] result = new int[1];
        // 考虑使用回溯
        BiConsumer<Integer, Integer> backtrack = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer step, Integer blocks) {
                result[0] = Math.max(result[0], blocks);
                if (step == maxSteps) {
                    return;
                }
                int row = step / m, column = step % m;
                if (!dominoes[row][column]) {
                    this.accept(step + 1, blocks);
                } else {
                    // 横放或竖放两种放牌方式
                    boolean flag = false;
                    // 横放
                    if ((step + 1) % m > column && dominoes[row][column + 1]) {
                        flag = true;
                        dominoes[row][column] = dominoes[row][column + 1] = false;
                        this.accept(step + 2, blocks + 1);
                        dominoes[row][column] = dominoes[row][column + 1] = true;
                    }

                    // 竖放
                    if ((row + 1) < n && dominoes[row + 1][column]) {
                        flag = true;
                        dominoes[row][column] = dominoes[row + 1][column] = false;
                        this.accept(step + 1, blocks + 1);
                        dominoes[row][column] = dominoes[row + 1][column] = true;
                    }

                    // 不满足任何放置方式 选择跳过不放
                    if (!flag) {
                        this.accept(step + 1, blocks);
                    }
                }
            }
        };
        backtrack.accept(0, 0);

        return result[0];
    }
}
