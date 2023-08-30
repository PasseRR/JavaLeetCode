package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * 示例:
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * <p>
 * 提示：
 * nums.length <= 10000
 * @author xiehai
 * @date 2020/08/10 15:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1011 {
    // #region snippet
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 奇数为谷 偶数为峰
            if (((i & 1) == 1 && nums[i] > nums[i - 1]) || ((i & 1) == 0 && nums[i] < nums[i - 1])) {
                nums[i] ^= nums[i - 1];
                nums[i - 1] ^= nums[i];
                nums[i] ^= nums[i - 1];
            }
        }
    }
    // #endregion snippet
}
