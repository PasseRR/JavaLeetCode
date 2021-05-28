package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * <p>
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * <p>
 * 示例 3：
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * @author xiehai
 * @date 2021/05/27 15:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1716 {
    public int massage(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];

        for (int i = 0; i < len; i++) {
            // 当前最大值为前2、3中的最大值 + 当前值
            dp[i + 1] = Integer.max(i - 1 >= 0 ? dp[i - 1] : 0, i - 2 >= 0 ? dp[i - 2] : 0) + nums[i];
        }

        // 最大值为最后两个值中的较大值
        return len > 1 ? Integer.max(dp[len], dp[len - 1]) : dp[len];
    }
}
