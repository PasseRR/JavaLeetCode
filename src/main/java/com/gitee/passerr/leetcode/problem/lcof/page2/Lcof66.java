package com.gitee.passerr.leetcode.problem.lcof.page2;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * @author xiehai
 * @date 2020/07/22 09:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        // 从左往右累乘 不乘自己
        for (int i = 0, product = 1; i < len; i++) {
            b[i] = product;
            product *= a[i];
        }

        // 从右往左累乘 不乘自己
        for (int i = len - 1, product = 1; i >= 0; i--) {
            b[i] *= product;
            product *= a[i];
        }

        return b;
    }
}
