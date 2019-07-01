package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author xiehai
 * @date 2019/07/01 10:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length, length = length1 + length2;
        // 合并数组
        int[] mergeArray = new int[length];

        // 合并数组索引及遍历两个数组的索引
        int i = 0, j = 0, k = 0;
        while (j < length1 && k < length2) {
            // 有序合并
            if (nums1[j] > nums2[k]) {
                mergeArray[i++] = nums2[k++];
            } else {
                mergeArray[i++] = nums1[j++];
            }
        }

        // 数组1剩余部分
        while (j < length1) {
            mergeArray[i++] = nums1[j++];
        }

        // 数组2剩余部分
        while (k < length2) {
            mergeArray[i++] = nums2[k++];
        }

        return
            length % 2 == 0
                // 合并数组长度为偶数
                ? (mergeArray[length / 2] + mergeArray[length / 2 - 1]) / 2.0
                // 合并数组长度为奇数
                : mergeArray[length / 2] / 1.0;
    }
}
