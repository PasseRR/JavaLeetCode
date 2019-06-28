package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author xiehai
 * @date 2019/06/28 15:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 从数组头开始
        for(int i = 0; i < nums.length; i ++) {
            // 从数组尾开始
            for(int j = nums.length - 1; j > i; j --) {
                // 找到结果直接返回
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 根据题意 不会出现找不到解的情况
        return null;
    }
}
