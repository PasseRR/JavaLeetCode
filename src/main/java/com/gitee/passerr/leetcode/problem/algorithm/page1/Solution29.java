package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * <p>
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * @author xiehai
 * @date 2019/07/04 15:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        // 由于使用正数会导致溢出
        // 所有数字均换为负数 正数最大值改为负数不会溢出
        // 正负标识
        boolean isPositive = dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int result = 0;
        while (dividend <= divisor) {
            // 除数翻倍的次数
            int times = 0;
            int timesDivisor = divisor;
            // timesDivisor < 0 防止负数位移溢出
            while (dividend <= timesDivisor) {
                result += 1 << times;
                dividend -= timesDivisor;
                // 除数翻倍
                times++;
                timesDivisor <<= 1;
                // 位移溢出
                if(timesDivisor >= 0) {
                    break;
                }
            }
        }

        // 若符号为正 结果为负数 则正数溢出
        return isPositive ? (result < 0 ? Integer.MAX_VALUE : result) : -result;
    }
}
