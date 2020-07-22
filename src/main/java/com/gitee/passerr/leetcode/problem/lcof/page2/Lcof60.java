package com.gitee.passerr.leetcode.problem.lcof.page2;

import java.util.stream.IntStream;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * 1 <= n <= 11
 * @author xiehai
 * @date 2020/07/22 09:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n][6 * n];
        // 当只有一个骰子的时候 每个点数都只有一种方法
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            // n个骰子可以投掷j点的方式
            for (int j = i; j < (i + 1) * 6; j++) {
                dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] += j - 2 >= 0 ? dp[i - 1][j - 2] : 0;
                dp[i][j] += j - 3 >= 0 ? dp[i - 1][j - 3] : 0;
                dp[i][j] += j - 4 >= 0 ? dp[i - 1][j - 4] : 0;
                dp[i][j] += j - 5 >= 0 ? dp[i - 1][j - 5] : 0;
                dp[i][j] += j - 6 >= 0 ? dp[i - 1][j - 6] : 0;
            }
        }

        int total = (int) Math.pow(6, n);

        return
            IntStream.rangeClosed(n - 1, 6 * n - 1)
                .mapToDouble(it -> dp[n - 1][it] / (total * 1.0D))
                .toArray();
    }
}
