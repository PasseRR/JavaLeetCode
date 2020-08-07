package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 说明:
 * A.length == n + m
 * @author xiehai
 * @date 2020/08/07 17:49
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        // i为A最大元素索引 j为B最大元素索引 k为A末尾索引
        int i = m - 1, j = n - 1, k = A.length - 1;

        // 双指针
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        // A剩余元素
        while (i >= 0) {
            A[k--] = A[i--];
        }

        // B剩余元素
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
