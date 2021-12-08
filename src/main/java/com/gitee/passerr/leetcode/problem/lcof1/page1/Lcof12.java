package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * @author xiehai
 * @date 2020/07/04 14:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof12 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length, len = word.length();
        // 访问过的路径
        boolean[][] visited = new boolean[rows][columns];

        TrFunction<Integer, Integer, Integer, Boolean> backtrack = new TrFunction<Integer, Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer row, Integer column, Integer index) {
                // 已经匹配最后一个字符
                if (index == len) {
                    return true;
                }

                // 越界或者已经访问过或者字符不匹配
                if (row < 0 || row >= rows
                    || column < 0 || column >= columns
                    || visited[row][column]
                    || board[row][column] != word.charAt(index)) {
                    return false;
                }

                visited[row][column] = true;
                // 继续匹配下一个字符
                if (this.apply(row + 1, column, index + 1)
                    || this.apply(row, column + 1, index + 1)
                    || this.apply(row - 1, column, index + 1)
                    || this.apply(row, column - 1, index + 1)) {
                    return true;
                }
                // 回溯
                visited[row][column] = false;

                return false;
            }
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (backtrack.apply(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    interface TrFunction<P1, P2, P3, R> {
        R apply(P1 p1, P2 p2, P3 p3);
    }
}
