package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.Arrays;

/**
 * 给定一个字符串S和一个字符串T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 * <p>
 * 示例1:
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出:3
 * 解释:
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * <p>
 * 示例2:
 * 输入: S = "babgbag", T = "bag"
 * 输出:5
 * 解释:
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag;
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 * <p>
 * 提示：
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * @author xiehai
 * @date 2019/08/05 11:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int sl = s.length(), tl = t.length();
        int[][] dp = new int[tl + 1][sl + 1];
        // t为空字符串 只有一种方法
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= tl; i++) {
            for (int j = 1; j <= sl; j++) {
                // 若都按照删除方法
                dp[i][j] = dp[i][j - 1];

                // 若字符一致
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[tl][sl];
    }
}
