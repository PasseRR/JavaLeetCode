package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author xiehai
 * @date 2019/07/17 16:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        // 缓存颜色数量
        int[] colors = new int[3];
        int length = nums.length;
        for (int num : nums) {
            colors[num] += 1;
        }

        // 遍历颜色 按顺序赋值
        int i = 0, j = 0;
        while (i < colors.length && j < length) {
            while (colors[i] > 0) {
                nums[j++] = i;
                colors[i]--;
            }
            i++;
        }
    }
}
