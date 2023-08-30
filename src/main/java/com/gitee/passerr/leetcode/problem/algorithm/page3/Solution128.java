package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author xiehai
 * @date 2020/06/05 18:02
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution128 {
    // #region snippet
    static class UnionFindSet {
        /**
         * 父节点
         */
        Map<Integer, Integer> node = new HashMap<>();
        /**
         * 连续数量
         */
        Map<Integer, Integer> cnt = new HashMap<>();

        void init(int num) {
            this.node.put(num, num);
            this.cnt.put(num, 1);
        }

        int find(int num) {
            int value = this.node.get(num);
            if (value == num) {
                return num;
            } else {
                int ancestor = this.find(value);
                this.node.put(num, ancestor);

                return ancestor;
            }
        }

        void union(int num) {
            if (!this.node.containsKey(num)) {
                this.init(num);
            }

            if (this.node.containsKey(num + 1)) {
                this.doUnion(num, num + 1);
            }

            if (this.node.containsKey(num - 1)) {
                this.doUnion(num, num - 1);
            }
        }

        void doUnion(int num1, int num2) {
            int parent1 = this.find(num1), parent2 = this.find(num2);
            if (parent1 > parent2) {
                this.node.put(parent2, parent1);
                this.cnt.merge(parent1, this.cnt.get(parent2), Integer::sum);
            } else if (parent1 < parent2) {
                this.node.put(parent1, parent2);
                this.cnt.merge(parent2, this.cnt.get(parent1), Integer::sum);
            }

            // 重复数据父节点一致 不用做合并
        }

        int result() {
            return this.cnt.values().stream().max(Comparator.comparingInt(it -> it)).orElse(0);
        }
    }

    public int longestConsecutive(int[] nums) {
        UnionFindSet set = new UnionFindSet();
        for (int num : nums) {
            set.union(num);
        }

        return set.result();
    }
    // #endregion snippet
}
