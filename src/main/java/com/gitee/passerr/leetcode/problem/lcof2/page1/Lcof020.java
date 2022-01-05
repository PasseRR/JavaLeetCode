package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.function.BiFunction;

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
 * 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/
 * @author xiehai
 * @date 2021/12/20 17:59
 */
public class Lcof020 {
    public int countSubstrings(String s) {
        int len = s.length();
        // 0表示未初始化 1表示是回文 2表示非回文
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        BiFunction<Integer, Integer, Boolean> isPalindrome = (left, right) -> {
            int i = 0;
            int mid = (left + right) >> 1 - left;
            while (i < mid) {
                if (s.charAt(left + i) != s.charAt(right - i)) {
                    return false;
                }
                i++;
            }

            return true;
        };
        
        // TODO

        for (int i = 0; i < len; i++) {

        }

        return 0;
    }
}
