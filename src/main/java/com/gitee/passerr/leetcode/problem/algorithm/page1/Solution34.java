package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author xiehai
 * @date 2019/07/05 16:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution34 {
    // #region snippet
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int hitIndex = -1;

        // 二分查找找到target所在位置
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                hitIndex = mid;
                break;
            }
        }

        // 向左右遍历 直到不与target相等
        if (hitIndex > -1) {
            result[0] = hitIndex;
            result[1] = hitIndex;

            int i = hitIndex - 1;
            while (i >= 0 && nums[i] == target) {
                i--;
                result[0]--;
            }
            i = hitIndex + 1;
            while (i < nums.length && nums[i] == target) {
                i++;
                result[1]++;
            }
        }

        return result;
    }
    // #endregion snippet
}
