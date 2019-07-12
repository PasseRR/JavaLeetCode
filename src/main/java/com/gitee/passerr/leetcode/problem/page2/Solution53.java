package com.gitee.passerr.leetcode.problem.page2;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author xiehai
 * @date 2019/07/11 15:44
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0], length = nums.length, sum = nums[0];
        for (int i = 1; i < length; i++) {
            // 如果左边和小于0 从当前数字开始 否则和之前相加
            sum = sum > 0 ? sum + nums[i] : nums[i];
            if (sum > result) {
                result = sum;
            }
        }

        return result;
    }
}
