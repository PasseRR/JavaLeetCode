package com.gitee.passerr.leetcode.problem.lcof.page1;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * <p>
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * @author xiehai
 * @date 2020/07/04 14:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof15 {
    public int hammingWeight(int n) {
        int count = 0;
        // 汉明距离
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }
}
