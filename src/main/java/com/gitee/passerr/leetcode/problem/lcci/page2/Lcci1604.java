package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * <p>
 * 示例 2：
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * <p>
 * 示例 3：
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * <p>
 * 提示：
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 * @author xiehai
 * @date 2020/08/14 11:00
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1604 {
    // #region snippet
    public String tictactoe(String[] board) {
        int n = board.length;
        char empty = ' ';
        // 按照行搜索
        String row =
            Arrays.stream(board)
                // 行第一个字符不能为空
                // 按照第一位字符计算总值
                .filter(it -> it.charAt(0) != empty && it.chars().allMatch(v -> v == it.charAt(0)))
                .findFirst()
                .map(it -> it.substring(0, 1))
                .orElse(null);
        if (row != null) {
            return row;
        }

        // 按照列搜索
        String column =
            IntStream.range(0, n)
                // 列第一个字符不能为空
                // 计算列总值是否一致
                .filter(col -> board[0].charAt(col) != empty)
                .filter(col -> IntStream.range(1, n)
                    .map(r -> board[r].charAt(col))
                    .allMatch(v -> v == board[0].charAt(col))
                )
                .mapToObj(col -> String.valueOf(board[0].charAt(col)))
                .findFirst()
                .orElse(null);
        if (column != null) {
            return column;
        }

        // 左对角线 若起点是空格跳过
        char left = board[0].charAt(0);
        if (left != empty && IntStream.range(1, n).map(it -> board[it].charAt(it)).allMatch(it -> it == left)) {
            return String.valueOf(left);
        }

        // 右对角线
        char right = board[0].charAt(n - 1);
        if (right != empty
            && IntStream.range(1, n).map(it -> board[it].charAt(n - 1 - it)).allMatch(it -> it == right)) {
            return String.valueOf(right);
        }

        // 根据是否存在空格判断
        return Arrays.stream(board).anyMatch(it -> it.contains(String.valueOf(empty))) ? "Pending" : "Draw";
    }
    // #endregion snippet
}
