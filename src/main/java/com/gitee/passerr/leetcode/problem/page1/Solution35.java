package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @author xiehai
 * @date 2019/07/05 16:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 刚好大于等于target
            if (nums[i] == target || nums[i] > target) {
                return i;
            }

            // 超过最大值
            if (i == length - 1) {
                return length;
            }
        }

        // 空数组
        return 0;
    }
}
