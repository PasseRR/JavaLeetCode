package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶：
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author xiehai
 * @date 2020/09/01 17:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1617 {
    // #region snippet
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, append = 0;
        for (int num : nums) {
            // 若单个数字是最大值
            max = Integer.max(num, max);
            // 若累加结果大于0 则可以继续追加
            if (append + num > 0) {
                append += num;
                max = Integer.max(max, append);
            } else {
                // 累加结果小于0 结束累加
                append = 0;
            }
        }

        return max;
    }
    // #endregion snippet
}
