package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @author xiehai
 * @date 2019/07/26 12:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = new int[length + 1];
        // 从最后一行开始
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0, columns = triangle.get(i).size(); j < columns; j++) {
                // 累加计算每一行最小值
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        // 计算到第一行的第一个元素为解
        return dp[0];
    }
}
