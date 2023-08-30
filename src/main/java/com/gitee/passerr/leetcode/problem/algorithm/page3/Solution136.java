package com.gitee.passerr.leetcode.problem.algorithm.page3;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author xiehai
 * @date 2019/07/26 11:08
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution136 {
    // #region snippet
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            // 两个相同的数异或结果为0
            // 任何数字与0异或得本身
            result ^= nums[i];
        }

        return result;
    }
    // #endregion snippet
}
