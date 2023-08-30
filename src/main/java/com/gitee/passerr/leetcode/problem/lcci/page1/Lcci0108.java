package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 示例 2：
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * @author xiehai
 * @date 2020/06/05 16:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page2.Solution73
 */
public class Lcci0108 {
    // #region snippet
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        Map<Integer, Set<Integer>> cache = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    // 记录为0的位置
                    cache.merge(i, new HashSet<>(Collections.singleton(j)), (n, o) -> {
                        n.addAll(o);
                        return n;
                    });
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if (cache.containsKey(i)) {
                // 行修改为0
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
                for (Integer column : cache.get(i)) {
                    // 列修改为0
                    for (int j = 0; j < rows; j++) {
                        matrix[j][column] = 0;
                    }
                }
            }
        }
    }
    // #endregion snippet
}
