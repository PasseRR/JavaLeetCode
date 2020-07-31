package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * |[
 * | [".Q..",  // 解法 1
 * |  "...Q",
 * |  "Q...",
 * |  "..Q."],
 * | ["..Q.",  // 解法 2
 * |  "Q...",
 * |  "...Q",
 * |  ".Q.."]
 * |]
 * @author xiehai
 * @date 2020/07/31 16:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0812 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 初始化空棋盘
        char[][] queens = new char[n][n];
        for (char[] queen : queens) {
            Arrays.fill(queen, '.');
        }

        // 截止第row行位置是否是合法的皇后棋盘
        // backtrack保证同一行不会出现多个皇后
        BiPredicate<Integer, Integer> isValid = (row, column) -> {
            // 同一列是否存在皇后
            for (int i = 0; i < row; i++) {
                if (queens[i][column] == 'Q') {
                    return false;
                }
            }

            // 两条对角线是否存在皇后
            for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
                if (queens[i][j] == 'Q') {
                    return false;
                }
            }

            for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
                if (queens[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        };

        // backtrack 每次从第一行开始
        Consumer<Integer> backtrack = new Consumer<Integer>() {
            @Override
            public void accept(Integer row) {
                if (row >= n) {
                    result.add(Arrays.stream(queens).map(String::new).collect(Collectors.toList()));
                    return;
                }

                for (int i = 0; i < n; i++) {
                    if (isValid.test(row, i)) {
                        queens[row][i] = 'Q';
                        this.accept(row + 1);
                        // 回溯
                        queens[row][i] = '.';
                    }
                }
            }
        };

        backtrack.accept(0);


        return result;
    }
}
