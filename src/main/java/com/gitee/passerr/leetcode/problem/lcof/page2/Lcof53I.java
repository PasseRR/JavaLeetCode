package com.gitee.passerr.leetcode.problem.lcof.page2;

import java.util.function.BiFunction;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author xiehai
 * @date 2020/07/14 16:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof53I {
    public int search(int[] nums, int target) {
        // 二分查找
        BiFunction<Integer, Integer, Integer> binarySearch = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer start, Integer end) {
                if (start > end || nums[end] < target || nums[start] > target) {
                    return 0;
                }

                if (nums[end] == target || nums[start] == target) {
                    int count = 0;
                    for (int i = start; i <= end; i++) {
                        count += nums[i] == target ? 1 : 0;
                    }

                    return count;
                }

                int mid = (start + end) >> 1;
                return this.apply(start, mid) + this.apply(mid + 1, end);
            }
        };

        return binarySearch.apply(0, nums.length - 1);
    }
}
