package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * @author xiehai
 * @date 2019/07/25 10:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution97 {
    // #region snippet
    /**
     * 在两个字符串 s1 和 s2 中依次取字母，问是否可以组成 S3。什么意思呢？比如 s1 = abc , s2 = de，s3 = abdce。
     * s1 取 1 个 字母得到 a，s1 再取个字母得到 ab，s2 取个字母得到 abd，
     * s1 取 1 个 字母得到 abdc， s2 取 1 个 字母得到 abdce，然后就得到了 s3，所以返回 true。
     * @param s1 s1
     * @param s2 s2
     * @param s3 s3
     * @return 是否可以交错组成
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int ls1 = s1.length(), ls2 = s2.length(), ls3 = s3.length();
        if ((ls1 + ls2) != ls3) {
            return false;
        }

        boolean[][] dp = new boolean[ls2 + 1][ls1 + 1];
        dp[0][0] = true;
        // 初始化s1和s3字符是否一样
        for (int i = 1; i <= ls1; i++) {
            dp[0][i] = dp[0][i - 1] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }
        // 初始化s2和s3字符是否一样
        for (int i = 1; i <= ls2; i++) {
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s2.charAt(i - 1);
        }

        for (int i = 1; i <= ls2; i++) {
            for (int j = 1; j <= ls1; j++) {
                // 公式同递归方法
                dp[i][j] = dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1)
                    || dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[ls2][ls1];
    }

    // 递归tle了
    public boolean isInterleave1(String s1, String s2, String s3) {
        int ls1 = s1.length(), ls2 = s2.length(), ls3 = s3.length();
        if ((ls1 + ls2) != ls3) {
            return false;
        }

        BiFunction<Integer, Integer, Boolean> recursion = new BiFunction<Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer i1, Integer i2) {
                if (i1 == ls1 && i2 == ls2) {
                    return true;
                }
                char c3 = s3.charAt(i1 + i2);
                return
                    (i1 != ls1 && s1.charAt(i1) == c3 && this.apply(i1 + 1, i2))
                        || (i2 != ls2 && s2.charAt(i2) == c3 && this.apply(i1, i2 + 1));
            }
        };

        return recursion.apply(0, 0);
    }
    // #endregion snippet
}
