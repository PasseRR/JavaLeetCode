package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * @author xiehai
 * @date 2019/07/19 13:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int rows, columns;
        if ((rows = board.length) == 0 || (columns = board[0].length) == 0) {
            return false;
        }
        // 记录是否已使用
        boolean[][] blackboard = new boolean[rows][columns];
        // 回溯搜索
        BiFunction<Integer, Integer, Boolean> backtrack = new BiFunction<Integer, Integer, Boolean>() {
            // 字符匹配索引
            private int index = 0;

            @Override
            public Boolean apply(Integer row, Integer column) {
                if (board[row][column] == word.charAt(index)) {
                    // 匹配完成
                    if (index + 1 == word.length()) {
                        return true;
                    }
                    // 向下遍历
                    if (row - 1 >= 0 && !blackboard[row - 1][column]) {
                        blackboard[row][column] = true;
                        this.index++;
                        boolean flag = this.apply(row - 1, column);
                        blackboard[row][column] = false;
                        this.index--;
                        if (flag) {
                            return true;
                        }
                    }
                    // 向上遍历
                    if (row + 1 < rows && !blackboard[row + 1][column]) {
                        blackboard[row][column] = true;
                        this.index++;
                        boolean flag = this.apply(row + 1, column);
                        blackboard[row][column] = false;
                        this.index--;
                        if (flag) {
                            return true;
                        }
                    }
                    // 向右遍历
                    if (column - 1 >= 0 && !blackboard[row][column - 1]) {
                        blackboard[row][column] = true;
                        this.index++;
                        boolean flag = this.apply(row, column - 1);
                        blackboard[row][column] = false;
                        this.index--;
                        if (flag) {
                            return true;
                        }
                    }
                    // 向左遍历
                    if (column + 1 < columns && !blackboard[row][column + 1]) {
                        blackboard[row][column] = true;
                        this.index++;
                        boolean flag = this.apply(row, column + 1);
                        blackboard[row][column] = false;
                        this.index--;

                        // 最后一种 可以直接返回
                        return flag;
                    }
                }

                return false;
            }
        };

        // 从网格中每个字符开始回溯是否能匹配word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (backtrack.apply(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
