package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 * @author xiehai
 * @date 2020/08/17 15:01
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1607 {
    // #region snippet
    public int maximum(int a, int b) {
        // a b的符号位
        int flagA = a >>> 31;
        int flagB = b >>> 31;
        // 获得a-b的差值符号位
        // 若差值为负数flag标识为1 否则为0
        // 若ab符号位一致 则结果符号位为a-b的符号位 a、b都是正数或者负数时 结果为a-b不会越界
        // 若ab符号位不一致 结果为a的符号位 a为负数b为正数或者a为正数b为负数结果可能会越界
        int flag = (flagA ^ flagB ^ 1) * (a - b) >>> 31 | (flagA ^ flagB) * flagA;
        // 若a > b flag为0 flag^1 = 1 结果为a
        // 若b > a flag为1 flag^1 = 0 结果为b
        return (flag ^ 1) * a + flag * b;
    }
    // #endregion snippet
}
