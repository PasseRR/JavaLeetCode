package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * @author xiehai
 * @date 2019/07/15 13:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 查询下一个排列的数字
        BiConsumer<Integer, Integer> permutation = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer base, Integer index) {
                if (base == 1) {
                    for (int i = 1; i <= n; i++) {
                        if (sb.indexOf(String.valueOf(i)) == -1) {
                            sb.append(i);
                            return;
                        }
                    }
                }
                if (index == 0) {
                    for (int i = n; i >= 1; i--) {
                        if (sb.indexOf(String.valueOf(i)) == -1) {
                            sb.append(i);
                            this.accept(base - 1, index);
                            return;
                        }
                    }
                }
                int solutions = IntStream.rangeClosed(1, base - 1).reduce(1, (x, y) -> x * y);
                int left = index % solutions;
                // 在未使用的数字中的索引 由小到大
                int numberIndex = index / solutions + (left > 0 ? 1 : 0), startIndex = 1;
                for (int i = 1; i <= n && startIndex <= numberIndex; i++) {
                    if (sb.indexOf(String.valueOf(i)) == -1) {
                        if (startIndex == numberIndex) {
                            sb.append(i);
                            break;
                        }
                        startIndex++;
                    }
                }

                this.accept(base - 1, left);
            }
        };

        permutation.accept(n, k);

        return sb.toString();
    }
}
