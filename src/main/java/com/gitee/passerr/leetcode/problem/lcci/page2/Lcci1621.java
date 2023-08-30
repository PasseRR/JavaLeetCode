package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 * 若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * <p>
 * 示例:
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * <p>
 * 提示：
 * 1 <= array1.length, array2.length <= 100000
 * @author xiehai
 * @date 2021/03/23 10:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1621 {
    // #region snippet
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        int dif = StrictMath.abs(sum1 - sum2);
        Arrays.sort(array1);
        Arrays.sort(array2);
        // 左边数组和大于等于右边数组和
        // 左边从高位开始 右边从低位开始
        if (sum1 >= sum2) {
            int i = array1.length - 1, k = 0;
            while (i >= 0 && k < array2.length) {
                if ((array1[i] - array2[k]) * 2 == dif) {
                    return new int[]{array1[i], array2[k]};
                } else if (array1[i] - array2[k] < dif) {
                    k++;
                } else {
                    i--;
                }
            }

        } else {
            // 左边数组和小于右边数组和
            // 左边从低位开始 右边从高位开始
            int i = 0, k = array2.length - 1;
            while (i < array1.length && k >= 0) {
                if ((array2[k] - array1[i]) * 2 == dif) {
                    return new int[]{array1[i], array2[k]};
                } else if (array2[k] - array1[i] < dif) {
                    k--;
                } else {
                    i++;
                }
            }

        }

        return new int[0];
    }
    // #endregion snippet
}
