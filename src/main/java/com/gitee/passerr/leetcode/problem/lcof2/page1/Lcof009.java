package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个正整数数组nums和整数 k，请找出该数组内乘积小于k的连续的子数组的个数。
 * <p>
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 * <p>
 * 提示:
 * 1 <= nums.length <= 3 * 10<sup>4</sup>
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10<sup>6</sup>
 * <p>
 * 注意：本题与主站 713题相同：https://leetcode.cn/problems/subarray-product-less-than-k/
 * @author xiehai
 * @date 2021/12/13 16:07
 */
public class Lcof009 {
    // #region snippet
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, product = 1;
        int left = 0, right = 0;

        while (right < nums.length) {
            product *= nums[right];

            // 乘积大于k时 窗口滑动 必须保证左边界小于等于右边界 否则当k小于当前左边界时会越界
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            // 子数组长度 = 1 + 2 + .. + 数组长度
            result += right - left + 1;
            right++;
        }

        return result;
    }
    // #endregion snippet
}
