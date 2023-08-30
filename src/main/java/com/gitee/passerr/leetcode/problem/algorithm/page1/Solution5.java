package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.function.Function;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @author xiehai
 * @date 2019/07/01 11:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution5 {
    // #region snippet
    public String longestPalindrome(String s) {
        // 是否是回文字符串
        Function<StringBuilder, Boolean> isPalindrome = str -> {
            // 长度为1 返回true
            if (str.length() == 1) {
                return true;
            }

            for (int i = 0, length = str.length(); i < length / 2; i++) {
                if (str.charAt(i) != str.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        };

        // 空字符串
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = s.length(); i < length; i++) {
            for (int j = i; j < s.length(); j++) {
                sb.append(s, j, j + 1);
                if (isPalindrome.apply(sb) && sb.length() > result.length()) {
                    result = sb.toString();
                }
            }
            sb.delete(0, sb.length());
        }
        return result;
    }
    // #endregion snippet
}
