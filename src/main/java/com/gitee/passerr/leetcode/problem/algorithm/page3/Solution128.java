package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author xiehai
 * @date 2020/06/05 18:02
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        Arrays.sort(nums);
        int count = 1, max = 1;
        int last = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == last) {
                continue;
            }

            if (nums[i] == last + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            last = nums[i];
        }

        return Math.max(max, count);
    }
}
