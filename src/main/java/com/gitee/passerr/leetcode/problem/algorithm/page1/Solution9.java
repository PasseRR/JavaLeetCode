package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * @author xiehai
 * @date 2019/07/02 10:10
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution9 {
    // #region snippet
    public boolean isPalindrome(int x) {
        // 负数都不是回文数
        if (x < 0) {
            return false;
        }
        // 单位整数都是回文数
        if (x < 10) {
            return true;
        }

        int hold = x;
        int reverse = 0;
        // 多位整数倒转与源数字比较 相同则为回文数
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == hold;
    }
    // #endregion snippet
}
