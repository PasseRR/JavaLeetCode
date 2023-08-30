package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * 注意：本题与主站 647 题相同：https://leetcode.cn/problems/palindromic-substrings/
 * @author xiehai
 * @date 2021/12/20 17:59
 */
public class Lcof020 {
    // #region snippet
    public int countSubstrings(String s) {
        int len = s.length(), result = 0;
        // 保存子字符串是否是回文字符串
        boolean[][] dp = new boolean[len][len];

        // 尾部字符
        for (int i = 0; i < len; i++) {
            // 头部字符
            for (int j = 0; j <= i; j++) {
                // 若首尾字母相同 判断去掉首尾区间是否是回文字符串
                // 若中间有0个或者1个字符，则肯定是回文字符串
                // 否则 需要判断中间区间子字符串是否是回文
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
