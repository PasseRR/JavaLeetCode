package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * @author xiehai
 * @date 2019/07/24 13:46
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution70
 */
public class Solution91 {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        // 以0开头 无法解码
        if (s.charAt(0) == '0') {
            return 0;
        }

        dp[0] = 1;
        if (length > 1) {
            // 头两个字母是否在[10, 26]区间
            if (s.charAt(1) == '0') {
                if (s.charAt(0) != '1' && s.charAt(0) != '2') {
                    return 0;
                } else {
                    dp[1] = 1;
                }
            } else {
                if ("10".compareTo(s.substring(0, 2)) <= 0 && "26".compareTo(s.substring(0, 2)) >= 0) {
                    dp[1] = 2;
                } else {
                    dp[1] = 1;
                }
            }
        }

        for (int i = 2; i < length; i++) {
            if (s.charAt(i) == '0') {
                // 不存在解码方式
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                } else {
                    // 当前字符和前一字符只有一种解码方式
                    dp[i] = dp[i - 2];
                }
            } else {
                if ("10".compareTo(s.substring(i - 1, i + 1)) <= 0 && "26".compareTo(s.substring(i - 1, i + 1)) >= 0) {
                    // 存在两种解码方式
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    // 可选一种解码方式
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[length - 1];
    }
}
