package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 限制：
 * 1 <= n <= 10000
 * @author xiehai
 * @date 2020/07/22 09:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof64 {
    public int sumNums(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }
}
