package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @author xiehai
 * @date 2020/07/04 13:54
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof03 {
    // #region snippet
    public int findRepeatNumber(int[] nums) {
        // 根据题意数字小于数组长度
        boolean[] dp = new boolean[nums.length];
        for (int num : nums) {
            if (dp[num]) {
                return num;
            }

            dp[num] = true;
        }

        return -1;
    }
    // #endregion snippet
}
