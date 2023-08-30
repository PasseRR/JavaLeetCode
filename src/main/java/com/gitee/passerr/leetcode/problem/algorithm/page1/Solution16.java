package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author xiehai
 * @date 2019/07/02 18:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution16 {
    // #region snippet
    public int threeSumClosest(int[] nums, int target) {
        // 排序數組
        Arrays.sort(nums);
        // 最接近target的值
        int closestTarget = nums[0] + nums[1] + nums[2];
        // 类似快排的方式找到三个和为0的数字
        for (int i = 0, length = nums.length; i < length; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k && k > i) {
                int iv = nums[i], jv = nums[j], kv = nums[k];
                int value = iv + jv + kv;
                if (value < target) {
                    j++;
                } else if (value > target) {
                    k--;
                } else {
                    return target;
                }

                if (Math.abs(target - value) < Math.abs(target - closestTarget)) {
                    closestTarget = value;
                }
            }
        }

        return closestTarget;
    }
    // #endregion snippet
}
