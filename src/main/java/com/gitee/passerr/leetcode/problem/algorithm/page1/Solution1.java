package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author xiehai
 * @date 2019/06/28 15:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1 {
    // #region snippet
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                return new int[]{cache.get(nums[i]), i};
            }
            // 表示nums[i]要够成target所需要的目标值
            cache.put(target - nums[i], i);
        }

        // 不会出现无解
        return null;
    }
    // #endregion snippet
}
