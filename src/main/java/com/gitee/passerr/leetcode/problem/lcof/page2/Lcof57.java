package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * @author xiehai
 * @date 2020/07/21 17:11
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 双指针
        while (left < right) {
            // 左右和
            int sum = nums[left] + nums[right];
            // 若和大于目标值 右边减小
            if (sum > target) {
                right--;
            } else if (sum < target) {
                // 若和小于目标值 左边增大
                left++;
            } else {
                // 找到满足要求的解
                break;
            }
        }

        return new int[]{nums[left], nums[right]};
    }
}
