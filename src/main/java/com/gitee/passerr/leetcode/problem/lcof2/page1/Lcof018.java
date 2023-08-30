package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个字符串 s ，验证 s是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * 注意：本题与主站 125题相同：https://leetcode.cn/problems/valid-palindrome/
 * @author xiehai
 * @date 2021/12/20 15:19
 */
public class Lcof018 {
    // #region snippet
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // 左右字符比较
            char left, right;
            // 直到左边第一个字母数字字符
            while (!Character.isLetter(left = s.charAt(i)) && !Character.isDigit(left) && i < j) {
                i++;
            }

            // 直到右边第一个字符数字字符
            while (!Character.isLetter(right = s.charAt(j)) && !Character.isDigit(right) && i < j) {
                j--;
            }

            // 忽略大小写比较
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            // 下一个字符比较
            i++;
            j--;
        }

        return true;
    }
    // #endregion snippet
}
