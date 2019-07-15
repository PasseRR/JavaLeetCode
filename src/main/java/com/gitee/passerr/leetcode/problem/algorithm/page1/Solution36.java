package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * <p>
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * @author xiehai
 * @date 2019/07/05 17:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // 使用hash表记录出现的字符
        // key表示第n行、第n列、第n个3X3块中出现的数字
        // 0~8表示行
        // 9~17表示列
        // 18~26表示3X3块
        Map<Integer, Set<Character>> snapshot = new HashMap<>(9);
        IntStream.range(0, 27)
            .forEach(index -> snapshot.put(index, new HashSet<>(9)));

        // 遍历行列所在3X3块 移除出现的字符
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 所属列
                int column = j + 9;
                // 所属第n个3X3块
                int block = (i / 3) * 3 + j / 3 + 18;
                if ('.' != board[i][j] && (
                    !snapshot.get(i).add(board[i][j])
                        // 对应列存在该字符
                        || !snapshot.get(column).add(board[i][j])
                        // 对应3X3块存在该字符
                        || !snapshot.get(block).add(board[i][j]))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        // 行、列、3X3是否已经存在某个数字
        BiFunction<Integer, Integer, Boolean> isExists = (row, column) -> {
            char current = board[row][column];
            // 遍历指定行 移除出现的字符
            for (int i = 0; i < 9; i++) {
                if (column != i && board[row][i] == current) {
                    return true;
                }
            }
            // 遍历指定列 移除出现字符
            for (int i = 0; i < 9; i++) {
                if (row != i && board[i][column] == current) {
                    return true;
                }
            }
            // 遍历开始行列
            int startRow = row - row % 3, startColumn = column - column % 3;
            // 遍历行列所在3X3块 移除出现的字符
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    if (i != row && j != column && board[i][j] == current) {
                        return true;
                    }
                }
            }

            return false;
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && isExists.apply(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
