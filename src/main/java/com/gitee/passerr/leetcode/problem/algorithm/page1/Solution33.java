package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @author xiehai
 * @date 2019/07/05 15:21
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution33 {
    // #region snippet
    public int search(int[] nums, int target) {
        int middle = -1, length = nums.length;
        // 找到中位数索引
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                // 中位数为较大的数字索引
                middle = i - 1;
                break;
            }
        }

        // 本身是旋转过的 排序
        if (middle >= 0) {
            Arrays.sort(nums);
        }

        // 二分查找
        int index = Arrays.binarySearch(nums, target);
        // 若本身就是有序 直接返回结果
        if (middle < 0) {
            return index > -1 ? index : -1;
        }

        // 旋转节点右边元素数量
        int offset = length - middle - 1;

        // 最后位置大于旋转位置 则元素应该在排序前左边 否则在右边
        return index > -1 ? (index < offset ? index + middle + 1 : index - offset) : -1;
    }
    // #endregion snippet
}
