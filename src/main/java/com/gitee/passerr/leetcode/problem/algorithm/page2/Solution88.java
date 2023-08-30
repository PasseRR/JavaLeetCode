package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @author xiehai
 * @date 2019/07/22 17:10
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution88 {
    // #region snippet
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 复制nums1前m个元素
        int[] nums1Source = new int[m];
        System.arraycopy(nums1, 0, nums1Source, 0, m);

        int i = 0, j = 0, k = 0;
        // 赋值nums1
        while (j < m && k < n) {
            if (nums1Source[j] < nums2[k]) {
                nums1[i++] = nums1Source[j++];
            } else {
                nums1[i++] = nums2[k++];
            }
        }

        // 若复制的nums1Source剩余元素
        while (j < m) {
            nums1[i++] = nums1Source[j++];
        }

        // 若nums2剩余元素
        while (k < n) {
            nums1[i++] = nums2[k++];
        }
    }
    // #endregion snippet
}
