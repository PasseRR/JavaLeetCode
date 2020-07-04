package com.gitee.passerr.leetcode.problem.lcof.page1;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * @author xiehai
 * @date 2020/07/04 15:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof21 {
    public int[] exchange(int[] nums) {
        // 根据题意 最大值为10000
        int[] dp = new int[10001];
        // 记录数字出现次数
        for (int num : nums) {
            dp[num]++;
        }

        int[] result = new int[nums.length];
        int index = 0;
        // 添加奇数部分
        for (int i = 1; i < dp.length; i += 2) {
            if (dp[i] != 0) {
                Arrays.fill(result, index, index + dp[i], i);
                index += dp[i];
            }
        }
        // 添加偶数部分
        for (int i = 0; i < dp.length; i += 2) {
            if (dp[i] != 0) {
                Arrays.fill(result, index, index + dp[i], i);
                index += dp[i];
            }
        }

        return result;
    }
}
