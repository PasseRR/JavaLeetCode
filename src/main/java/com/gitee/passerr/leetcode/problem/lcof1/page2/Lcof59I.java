package com.gitee.passerr.leetcode.problem.lcof1.page2;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 *   滑动窗口的位置                最大值
 * ----------------               -----
 * |[1  3  -1] -3  5  3  6  7       3
 * | 1 [3  -1  -3] 5  3  6  7       3
 * | 1  3 [-1  -3  5] 3  6  7       5
 * | 1  3  -1 [-3  5  3] 6  7       5
 * | 1  3  -1  -3 [5  3  6] 7       6
 * | 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author xiehai
 * @date 2020/07/22 08:49
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }

        int[] result = new int[len - k + 1];
        int prefixMaxIndex = -1;
        for (int i = 0; i < len - k + 1; i++) {
            // 前一窗口最大值不在当前窗口内
            if (prefixMaxIndex < i) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j < k + i; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        prefixMaxIndex = j;
                    }
                }
                result[i] = max;
            } else if (nums[prefixMaxIndex] < nums[k + i - 1]) {
                // 前一窗口最大值小于当前窗口最后一个值
                prefixMaxIndex = k + i - 1;
                result[i] = nums[k + i - 1];
            } else {
                // 前一窗口最大值也是当前窗口最大值
                result[i] = nums[prefixMaxIndex];
            }
        }

        return result;
    }
}
