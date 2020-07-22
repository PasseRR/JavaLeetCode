package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * @author xiehai
 * @date 2020/07/22 09:29
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof65 {
    public int add(int a, int b) {
        int sum = a, carry;
        while (b != 0) {
            // 异或结果为不需要进位的数字 如 (100 ^ 111) => 011
            sum = a ^ b;
            // 逻辑与结果为需要进位的数字 如 (100 & 111) >> 1 => 1000
            carry = (a & b) << 1;
            // 最终结果为 (011 + 1000) => 1011
            a = sum;
            b = carry;
        }

        return sum;
    }
}
