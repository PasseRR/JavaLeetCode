package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 * @author xiehai
 * @date 2020/08/25 16:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1704 {
    public int missingNumber(int[] nums) {
        // 使用异或计算
        int exor = 0;
        // 两个相同的数字异或结果为0 0异或任何数字为本身
        for (int i = 0; i < nums.length; i++) {
            // 先异或一遍0到n-1
            exor ^= i;
            // 异或数组数字
            exor ^= nums[i];
        }

        // 异或n
        exor ^= nums.length;

        return exor;
    }
}
