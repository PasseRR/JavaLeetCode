package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>
 * 示例：
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * <p>
 * 提示：
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 * @author xiehai
 * @date 2020/08/17 14:13
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1606 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = Integer.MAX_VALUE;
        int len1 = a.length, len2 = b.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            // 转为long 避免越界
            long diff = Math.abs((long) b[j] - (long) a[i]);
            // 获得最小差值
            result = Long.min(diff, result);
            // 使左右两边的数字尽量差值较小
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return (int) result;
    }
}
