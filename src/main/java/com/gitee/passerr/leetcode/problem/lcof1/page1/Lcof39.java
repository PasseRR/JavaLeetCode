package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 50000
 * 注意：本题与主站 169 题相同：https://leetcode.cn/problems/majority-element/
 * @author xiehai
 * @date 2020/07/14 12:53
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof39 {
    public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        // 摩尔投票
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 根据题意 有个数字出现超过数组长度一半
                // 出现次数为0时 必有下一个数字来设置count为1
                result = nums[i];
                count = 1;
            } else if (result != nums[i]) {
                // 数字不相同
                count--;
            } else {
                // 数字相同
                count++;
            }
        }

        return result;
    }
}
