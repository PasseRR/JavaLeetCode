package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode.cn/problems/ugly-number-ii/
 * @author xiehai
 * @date 2020/07/14 13:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof49 {
    // #region snippet
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int n2, n3, n5;
        // 分别为可以为2、3、5为质因数的最小值
        n2 = n3 = n5 = 1;
        for (int i = 2; i <= n; i++) {
            // 最小数
            dp[i] = Integer.min(Integer.min(dp[n2] * 2, dp[n3] * 3), dp[n5] * 5);
            if (dp[i] % 2 == 0) {
                n2++;
            }

            if (dp[i] % 3 == 0) {
                n3++;
            }

            if (dp[i] % 5 == 0) {
                n5++;
            }
        }

        return dp[n];
    }
    // #endregion snippet
}
