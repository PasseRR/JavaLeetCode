package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 任意两个皇后都不能处于同一行、同一列或同一斜线上
 * @author xiehai
 * @date 2019/07/11 12:45
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 放置皇后置为1
        List<StringBuilder> queens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queens.add(new StringBuilder(String.join("", Collections.nCopies(n, "."))));
        }
        // 回溯找解
        Consumer<Integer> solve = new Consumer<Integer>() {
            @Override
            public void accept(Integer index) {
                if (index == n) {
                    result.add(
                        new ArrayList<>(queens.stream().map(StringBuilder::toString).collect(Collectors.toList()))
                    );
                    return;
                }

                for (int i = 0; i < n; i++) {
                    boolean found = false;
                    // 同一行存在皇后
                    if (queens.get(i).indexOf("Q") > -1) {
                        continue;
                    }
                    // 对角线上存在皇后
                    int j = i, k = index;
                    while (j >= 0 && k >= 0) {
                        if (queens.get(j--).charAt(k--) == 'Q') {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        continue;
                    }
                    j = i;
                    k = index;
                    while (j < n && k >= 0) {
                        if (queens.get(j++).charAt(k--) == 'Q') {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        continue;
                    }
                    // 拒绝同列出现多个皇后
                    queens.get(i).setCharAt(index, 'Q');
                    this.accept(index + 1);
                    // 回溯
                    queens.get(i).setCharAt(index, '.');
                }
            }
        };

        solve.accept(0);

        return result;
    }
}
