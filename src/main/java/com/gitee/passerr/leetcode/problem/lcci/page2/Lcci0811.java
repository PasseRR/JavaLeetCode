package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * 注意:
 * 你可以假设：
 * 0 <= n (总金额) <= 1000000
 * @author xiehai
 * @date 2020/07/31 13:28
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0811 {
    // #region snippet
    public int waysToChange(int n) {
        final int mod = 1000000007;
        // 空间压缩
        n /= 5;
        int[] dp = new int[n + 1];
        // 所有数字都可以用1分
        Arrays.fill(dp, 1);
        // 5分、10分、25分
        int[] coins = {1, 2, 5};

        // 由小到大计算方式
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }

        return dp[n];
    }
    // #endregion snippet
}
