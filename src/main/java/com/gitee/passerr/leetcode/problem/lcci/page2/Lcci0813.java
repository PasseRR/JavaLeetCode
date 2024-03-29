package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * <p>
 * 示例2:
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * <p>
 * 提示:
 * 箱子的数目不大于3000个。
 * @author xiehai
 * @date 2020/07/31 17:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0813 {
    // #region snippet
    public int pileBox(int[][] box) {
        // 将箱子按照高度升序排序
        Arrays.sort(box, Comparator.comparingInt(b -> b[2]));

        // 动态规划
        int[] dp = new int[box.length];
        // 第一个箱子最大高度为本身
        int result = dp[0] = box[0][2];

        for (int i = 1; i < box.length; i++) {
            // 长宽高小于i的最大箱子高度
            int max = 0;
            for (int j = 0; j < i; j++) {
                // 找到长宽高小于i的最大箱子高度
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    max = Integer.max(max, dp[j]);
                }
            }
            // 前i个箱子可以堆叠的最大高度
            dp[i] = max + box[i][2];
            // 所有箱子可堆叠的最大高度
            result = Integer.max(result, dp[i]);
        }

        return result;
    }
    // #endregion snippet
}
