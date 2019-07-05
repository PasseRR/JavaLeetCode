package com.gitee.passerr.leetcode.problem.page1;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author xiehai
 * @date 2019/07/05 10:34
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        // 从倒数第二个数字开始和之后的数字依次比较
        for (int length = nums.length, i = length - 2; i >= 0; i--) {
            // 找到第一个排在后面的大数字
            for (int j = length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    // 交换位置
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    // 将之后的排序 升序为字典第一个排列
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }

        // 未找到 或数量小于2 升序排序返回
        Arrays.sort(nums);
    }
}
