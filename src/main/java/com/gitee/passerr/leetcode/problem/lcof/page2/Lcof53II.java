package com.gitee.passerr.leetcode.problem.lcof.page2;

import java.util.function.BiFunction;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 10000
 * @author xiehai
 * @date 2020/07/14 16:20
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof53II {
    public int missingNumber(int[] nums) {
        BiFunction<Integer, Integer, Integer> binarySearch = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                // 数字不是从0开始
                if (nums[left] != left) {
                    return nums[left] - 1;
                }

                // 数字是从0开始且是连续的
                if (nums[left] == left && nums[right] == right) {
                    return nums[right] + 1;
                }

                // 数字是从0开始且非连续的
                int mid = (right + left) >> 1;
                return nums[mid] == mid ? this.apply(mid + 1, right) : this.apply(left, mid);
            }
        };

        return binarySearch.apply(0, nums.length - 1);
    }
}
