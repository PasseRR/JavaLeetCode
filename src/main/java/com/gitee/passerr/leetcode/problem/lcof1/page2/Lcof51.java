package com.gitee.passerr.leetcode.problem.lcof1.page2;

import java.util.function.BiFunction;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * @author xiehai
 * @date 2020/07/14 13:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof51 {
    // #region snippet
    public int reversePairs(int[] nums) {
        // 归并排序
        BiFunction<Integer, Integer, Integer> merge = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                // 区间只有一个数字 不存在逆序对
                if (left >= right) {
                    return 0;
                }

                int mid = (left + right) >> 1;
                // 递归左右区间 分治
                int count = this.apply(left, mid) + this.apply(mid + 1, right);
                // 区间长度、左区间开始位置、右区间开始位置、额外空间索引
                int len = right - left + 1, l = left, r = mid + 1, index = 0;
                // 额外空间长度
                int[] extra = new int[len];
                // 归并左右区间
                while (l <= mid && r <= right) {
                    if (nums[l] > nums[r]) {
                        extra[index++] = nums[r++];
                    } else {
                        // 右区间存在比左区间大的数字 计算逆序对数量 逆序对数量为当前已经遍历过的右区间的数量
                        count += r - mid - 1;
                        extra[index++] = nums[l++];
                    }
                }
                // 左区间剩余元素
                while (l <= mid) {
                    extra[index++] = nums[l++];
                    // 剩余元素都是比右区间大的数字 则与右区间所有数字都组成逆序对
                    count += right - mid;
                }
                // 右区间剩余元素
                while (r <= right) {
                    extra[index++] = nums[r++];
                }

                System.arraycopy(extra, 0, nums, left, len);

                return count;
            }
        };

        return merge.apply(0, nums.length - 1);
    }
    // #endregion snippet
}
