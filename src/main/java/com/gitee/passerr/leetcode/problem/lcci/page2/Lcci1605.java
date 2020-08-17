package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @author xiehai
 * @date 2020/08/17 13:39
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1605 {
    public int trailingZeroes(int n) {
        int count = 0;
        // 阶乘中5的数量小于偶数的数量
        // 任意偶数和5相乘都可以产生一个0
        // 只需要计算质因数为5出现的次数即可
        while (n >= 5) {
            count += (n /= 5);
        }
        return count;
    }
}
