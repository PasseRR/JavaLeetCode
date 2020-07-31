package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * 输入：A = 1, B = 10
 * 输出：10
 * <p>
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * <p>
 * 提示:
 * 保证乘法范围不会溢出
 * @author xiehai
 * @date 2020/07/31 13:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0805 {
    public int multiply(int A, int B) {
        // 递归出点
        if (A == 0 || B == 0) {
            return 0;
        }


        // 以3*4为例 拆分成 2*4 + 1*4 + 0
        // 若是25*4 拆分成 16*4 + 8*4 + 1*4 + 0
        int i = 31;
        // 找到最高位的1
        while ((A & 1 << i) == 0) {
            i--;
        }

        // 递归拆分
        return (B << i) + this.multiply(A - (1 << i), B);
    }
}
