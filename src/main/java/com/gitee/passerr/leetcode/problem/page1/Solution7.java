package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author xiehai
 * @date 2019/07/01 15:49
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution7 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x)).reverse();
        // 负数处理
        if (x < 0) {
            sb.insert(0, "-");
            sb.delete(sb.length() - 1, sb.length());
        }
        Long result = Long.valueOf(sb.toString());

        // 溢出判断
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return result.intValue();
    }
}
