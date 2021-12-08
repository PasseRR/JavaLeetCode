package com.gitee.passerr.leetcode.problem.lcof1.page2;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * @author xiehai
 * @date 2020/07/21 17:08
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof56II {
    public int singleNumber(int[] nums) {
        // 记录每一个位元出现的次数
        int[] bit = new int[32];

        for (int num : nums) {
            int i = 0;
            // 无符号右移 直至为0 统计每个位元出现的次数
            while (num != 0) {
                bit[i++] += num & 1;
                num >>>= 1;
            }
        }

        int result = 0;
        // 遍历位元数组 若不能被3整除 表示这个位元为1 否则为0
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] % 3 != 0) {
                result |= 1 << i;
            }
        }

        return result;
    }
}
