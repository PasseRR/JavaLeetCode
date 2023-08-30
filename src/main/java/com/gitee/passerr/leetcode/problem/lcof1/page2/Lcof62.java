package com.gitee.passerr.leetcode.problem.lcof1.page2;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * @author xiehai
 * @date 2020/07/22 09:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof62 {
    // #region snippet
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 如n=6 m=4
        // 0 1 2 3 4 5 -> 0 1 2 4 5 -> 0 2 4 5 -> 2 4 5 -> 4 5 -> 4
        // 最后一轮剩两个数字 倒推是第几个索引位置
        // 剩两个元素 m%2=0 说明移除的是0位置的元素
        // 剩三个元素 m%3=1 说明移除的是1位置的元素
        // 剩四个元素 (m+1)%4=1 说明移除的是1位置的元素
        // 剩五个元素 (m+1)%5=0 说明移除的是0位置的元素
        // 剩六个元素 m%6=4 说明移除的是4位置的元素
        for (int i = 2; i <= n; i++) {
            ans += m;
            ans %= i;
        }

        return ans;
    }
    // #endregion snippet
}
