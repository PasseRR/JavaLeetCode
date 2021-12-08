package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * @author xiehai
 * @date 2020/07/14 13:01
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof42 {
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
