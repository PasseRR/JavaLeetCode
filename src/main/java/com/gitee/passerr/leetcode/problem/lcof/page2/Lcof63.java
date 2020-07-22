package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 10^5
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author xiehai
 * @date 2020/07/22 09:24
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof63 {
    public int maxProfit(int[] prices) {
        // 最大收益、最低买入价格
        int max = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            // 当出现一个低价时 是一个买入时机
            buy = Integer.min(buy, price);
            // 比较最大收益
            max = Integer.max(max, price - buy);
        }

        return max;
    }
}
