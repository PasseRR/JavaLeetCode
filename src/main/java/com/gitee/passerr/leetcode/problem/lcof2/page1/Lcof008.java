package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= target <= 10<sup>9</sup>
 * 1 <= nums.length <= 10<sup>5</sup>
 * 1 <= nums[i] <= 10<sup>5</sup>
 * <p>
 * 进阶：
 * 如果你已经实现 O(n<Sup>2</Sup>) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * 注意：本题与主站 209题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author xiehai
 * @date 2021/12/13 14:09
 */
public class Lcof008 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length, result = len + 1, sum = 0;
        int left = 0, right = 0;

        while (left < len && right < len) {
            sum += nums[right];
            // 滑动窗口
            while (sum >= target) {
                result = Integer.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return result > len ? 0 : result;
    }
}
