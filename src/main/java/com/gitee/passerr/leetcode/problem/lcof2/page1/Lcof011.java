package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * <p>
 * 注意：本题与主站 525题相同：https://leetcode.cn/problems/contiguous-array/
 * @author xiehai
 * @date 2021/12/16 10:13
 */
public class Lcof011 {
    // #region snippet
    public int findMaxLength(int[] nums) {
        int result = 0;
        // 0、1的个数
        int c0 = 0, c1 = 0;
        // 0、1个数相差个数缓存 key为差值 value为索引
        Map<Integer, Integer> hits = new HashMap<>();

        for (int i = 0, len = nums.length; i < len; i++) {
            // 累加0、1个数
            c0 += 1 ^ nums[i];
            c1 += 1 & nums[i];
            // 1比0多的个数
            int diff = c1 - c0;
            if (diff == 0) {
                // 从开始到i位置0和1的个数一样多
                // 这个长度肯定是当前最长的
                result = i + 1;
            } else if (!hits.containsKey(diff)) {
                // 若存在一个前缀数组的0、1个数和当前个数相反 则两段之间的部分0、1个数一致
                result = Integer.max(result, i - hits.get(diff));
            } else {
                // 否则缓存差值及索引
                hits.put(diff, i);
            }
        }

        return result;
    }
    // #endregion snippet
}
