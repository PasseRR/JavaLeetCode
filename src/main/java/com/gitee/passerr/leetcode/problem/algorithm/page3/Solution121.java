package com.gitee.passerr.leetcode.problem.algorithm.page3;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author xiehai
 * @date 2020/06/05 17:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution121 {
    // #region snippet
    public int maxProfit(int[] prices) {
        int max = 0, length = prices.length;
        if(length > 0) {
            // 默认买入第一个
            int buy = prices[0];
            for(int i = 1; i < length; i ++) {
                if(buy > prices[i]) {
                    // 当出现一个低价时 是一个买入时机
                    buy = prices[i];
                } else {
                    int profit = prices[i] - buy;
                    // 比较最大收益
                    if(profit > max) {
                        max = profit;
                    }
                }
            }
        }

        return max;
    }
    // #endregion snippet
}
