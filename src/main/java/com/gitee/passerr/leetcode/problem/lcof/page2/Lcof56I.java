package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 限制：
 * 2 <= nums.length <= 10000
 * @author xiehai
 * @date 2020/07/21 17:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof56I {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        // 根据题意xor结果为两个出线一次的数字异或结果
        // 相同数字异或为0
        for (int num : nums) {
            xor ^= num;
        }

        // 异或结果最靠右的位元1
        int right = xor & (-xor);

        int result = 0;
        for (int num : nums) {
            // 将数字与最靠右的位元1是否存在分组
            // 将两个数字分为两组
            if ((num & right) == 0) {
                // 此处必得到一个数字
                result ^= num;
            }
        }

        // 另一个数字可以根据异或结果再次计算
        return new int[]{result, xor ^ result};
    }
}
