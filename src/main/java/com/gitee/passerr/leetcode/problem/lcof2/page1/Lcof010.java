package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数k ，请找到该数组中和为k的连续子数组的个数。
 * <p>
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * <p>
 * 示例 2:
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 2 * 10<sup>4</sup>
 * -1000 <= nums[i] <= 1000
 * -10<sup>7</sup> <= k <= 10<sup>7</sup>
 * <p>
 * 注意：本题与主站 560题相同：https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @author xiehai
 * @date 2021/12/15 18:01
 */
public class Lcof010 {
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        // 前缀和为0的个数 仅作为初始化
        prefix.put(0, 1);

        for (int num : nums) {
            // 前缀和累加
            sum += num;
            // 若存在前缀和为sum-k则为解
            result += prefix.getOrDefault(sum - k, 0);
            // 合并前缀和为sum的子数组数量
            prefix.merge(sum, 1, Integer::sum);
        }

        return result;
    }
}
