package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 一个数独。
 * 答案被标成红色。
 * <p>
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * @author xiehai
 * @date 2019/07/08 16:27
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution37 {
    private static final List<Character> CHARACTERS = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void solveSudoku(char[][] board) {
        // 找到一个位置可填写数字
        BiFunction<Integer, Integer, List<Character>> availableChars = (row, column) -> {
            List<Character> chars = new ArrayList<>(CHARACTERS);
            // 遍历指定行 移除出现的字符
            for (char ch : board[row]) {
                chars.remove((Character) ch);
            }
            // 遍历指定列 移除出现字符
            for (char[] rowChars : board) {
                chars.remove((Character) rowChars[column]);
            }
            // 遍历开始行列
            int startRow = row - row % 3, startColumn = column - column % 3;
            // 遍历行列所在3X3块 移除出现的字符
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    chars.remove((Character) board[i][j]);
                }
            }

            // 获得可选择的字符
            return chars;
        };

        // 数字填充到数独
        BiFunction<Integer, Integer, Boolean> isValid = new BiFunction<Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer row, Integer column) {
                // 遍历过最后一个位置 满足条件
                if (row == 9) {
                    return true;
                }
                if (board[row][column] == '.') {
                    List<Character> apply = availableChars.apply(row, column);
                    // 若不存在可填写数字 结束尝试
                    if (apply.isEmpty()) {
                        return false;
                    }
                    // 拿到可用数字依次填写
                    for (Character character : apply) {
                        board[row][column] = character;
                        if (this.apply(row + (column + 1) / 9, (column + 1) % 9)) {
                            return true;
                        }
                        // 回溯
                        board[row][column] = '.';
                    }

                    return false;
                }

                return this.apply(row + (column + 1) / 9, (column + 1) % 9);
            }
        };

        isValid.apply(0, 0);
    }
}
