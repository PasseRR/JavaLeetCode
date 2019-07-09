package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * @author xiehai
 * @date 2019/07/09 11:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        // 从位置0开始放置
        int[] snapshot = new int[length];

        // 长度为length的数组 可以放置最大数字为length - 1
        // 超过则表示中间有断层数字
        for (int num : nums) {
            // 只取小于等于数组长度的数字
            if (num > 0 && num <= length) {
                snapshot[num - 1] = num;
            }
        }

        for (int i = 0; i < length; i++) {
            // 找到一个位置i数字不是i 则表示缺失该数字
            if (snapshot[i] != i + 1) {
                return i + 1;
            }
        }

        // 都存在表示从1开始顺序递增的 返回length+1为缺失数字
        // 可能数组为空
        return length == 0 ? 1 : length + 1;
    }
}
