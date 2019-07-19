package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * @author xiehai
 * @date 2019/07/19 16:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int length = nums.length, turnPoint = -1;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                turnPoint = i;
                break;
            }
        }

        return turnPoint < 0
            // 存在旋转点 两段二分搜索
            ? Arrays.binarySearch(nums, 0, length, target) > -1
            : Arrays.binarySearch(nums, 0, turnPoint, target) > -1 ||
            // 未旋转的 直接二分搜索
            Arrays.binarySearch(nums, turnPoint, length, target) > -1;
    }
}
