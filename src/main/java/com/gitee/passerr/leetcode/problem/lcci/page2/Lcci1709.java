package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 * @author xiehai
 * @date 2021/05/17 16:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.lcof.page1.Lcof49
 */
public class Lcci1709 {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int n3, n5, n7;
        // 分别为可以为3、5、7为质因数的最小值
        n3 = n5 = n7 = 0;
        for (int i = 1; i < k; i++) {
            // 每个数字递增一倍找到最小值
            int n = Integer.min(Integer.min(dp[n3] * 3, dp[n5] * 5), dp[n7] * 7);
            dp[i] = n;
            // 增加倍数
            if (n % 3 == 0) {
                n3++;
            }
            if (n % 5 == 0) {
                n5++;
            }
            if (n % 7 == 0) {
                n7++;
            }
        }

        return dp[k - 1];
    }
}
