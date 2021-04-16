package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * <p>
 * 示例 2:
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * <p>
 * 提示：
 * nums.length <= 100000
 * @author xiehai
 * @date 2021/04/16 13:51
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1624 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = nums.length - 1;

        // 双指针
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                result.add(Arrays.asList(nums[start], nums[end]));
                start++;
                end--;
            }
        }

        return result;
    }
}
