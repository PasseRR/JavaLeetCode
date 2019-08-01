package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * @author xiehai
 * @date 2019/08/01 10:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] != nums[i - 2]) {
                return nums[i - 2];
            }
        }

        return nums[nums.length - 1];
    }

    public int singleNumber1(int[] nums) {
        // x ^ 0 = x
        // x ^ x = 0
        // ab ^ 00 = ab
        // ab ^ ab = 0
        // x & ~x = 0
        // x & ~0 = x
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
