package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，
 * 也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * <p>
 * 提示：
 * 0 <= len(array) <= 1000000
 * @author xiehai
 * @date 2020/08/28 16:23
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1616 {
    // #region snippet
    public int[] subSort(int[] array) {
        // 从左向右 找到最后一个小于最大值的索引
        int max = Integer.MIN_VALUE, right = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                right = i;
            }
        }

        if (right < 0) {
            return new int[]{-1, -1};
        }

        // 从右向左 找到最后一个大于最小值的索引
        int min = Integer.MAX_VALUE, left = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                left = i;
            }
        }

        return new int[]{left, right};
    }
    // #endregion snippet
}
