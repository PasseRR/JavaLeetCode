package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @author xiehai
 * @date 2019/07/16 13:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        int al = a.length(), bl = b.length(), ai = al - 1, bi = bl - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (ai >= 0 || bi >= 0) {
            int sum = (ai < 0 ? 0 : a.charAt(ai) - '0')
                + (bi < 0 ? 0 : b.charAt(bi) - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            ai--;
            bi--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
