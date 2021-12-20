package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.function.BiFunction;

/**
 * 给定一个非空字符串s，请判断如果最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * <p>
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * 注意：本题与主站 680题相同：https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @author xiehai
 * @date 2021/12/20 16:01
 */
public class Lcof019 {
    public boolean validPalindrome(String s) {
        BiFunction<String, Boolean, Boolean> isPalindrome = new BiFunction<String, Boolean, Boolean>() {
            @Override
            public Boolean apply(String t, Boolean f) {
                int len = t.length(), mid = len >> 1, left = 0;
                while (left < mid) {
                    if (t.charAt(left) != t.charAt(len - left - 1)) {
                        // 只允许删除一个字符
                        if (!f) {
                            return false;
                        }

                        return
                            // 删除右边字符
                            this.apply(t.substring(left, len - left - 1), false)
                                // 删除左边字符
                                || this.apply(t.substring(left + 1, len - left), false);
                    }
                    left++;
                }

                return true;
            }
        };

        return isPalindrome.apply(s, true);
    }
}
