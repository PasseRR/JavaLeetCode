package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * @author xiehai
 * @date 2019/07/11 15:33
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution51
 */
public class Solution52 {
    // #region snippet
    public int totalNQueens(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
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
                    result.set(0, result.get(0) + 1);
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

        return result.get(0);
    }
    // #endregion snippet
}
