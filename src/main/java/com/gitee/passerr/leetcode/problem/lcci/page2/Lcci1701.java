package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * @author xiehai
 * @date 2020/08/25 17:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1701 {
    // #region snippet
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // 异或结果为不进位
            a = sum ^ b;
            // 逻辑与结果为进位
            b = (sum & b) << 1;
            // 数字交替
            sum = a;
        }

        return sum;
    }
    // #endregion snippet
}
