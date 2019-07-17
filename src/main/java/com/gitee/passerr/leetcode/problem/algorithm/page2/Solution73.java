package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * <p>
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * <p>
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * @author xiehai
 * @date 2019/07/17 12:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution73 {
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
}
