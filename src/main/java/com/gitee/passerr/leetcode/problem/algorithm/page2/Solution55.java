package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @author xiehai
 * @date 2019/07/12 14:32
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution55 {
    // #region snippet
    public boolean canJump(int[] nums) {
        // 第一步能到的最大位置
        int max = nums[0];
        for (int i = 1, length = nums.length; i < length; i++) {
            // 若当前最大位置不能到达i位置 结束
            if (max < i) {
                return false;
            }

            // 更新最大位置
            if (nums[i] + i > max) {
                max = nums[i] + i;
            }

            // 已经到达最后位置
            if (max >= length - 1) {
                return true;
            }
        }

        return true;
    }
    // #endregion snippet
}
