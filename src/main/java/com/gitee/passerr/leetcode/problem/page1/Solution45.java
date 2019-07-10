package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * @author xiehai
 * @date 2019/07/10 15:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution45 {
    public int jump(int[] nums) {
        // 数组长度、总步数
        int length = nums.length, steps = 0;
        // 当前步可以跳跃到达最大位置、当前已经跳过距离
        int maxRange = 0, currentRange = 0;

        for (int i = 0; i < length; i++) {
            // 若距离已经超过当前能到达范围 则需要多跳一步
            if (i > currentRange) {
                steps++;
                // 更新当前已跳过距离为上一步最大距离
                currentRange = maxRange;
            }

            // 发现可以跳得更远的距离
            if (i + nums[i] > maxRange) {
                maxRange = i + nums[i];
            }
        }

        return steps;
    }
}
