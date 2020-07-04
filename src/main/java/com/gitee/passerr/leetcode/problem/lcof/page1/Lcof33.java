package com.gitee.passerr.leetcode.problem.lcof.page1;

import java.util.function.BiFunction;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * |     5
 * |    / \
 * |   2   6
 * |  / \
 * | 1   3
 * <p>
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * 数组长度 <= 1000
 * @author xiehai
 * @date 2020/07/04 16:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof33 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len <= 2) {
            return true;
        }

        BiFunction<Integer, Integer, Boolean> recursion = new BiFunction<Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer from, Integer end) {
                if (from >= end) {
                    return true;
                }

                int left = from;
                // 左树都是小于根节点的值
                while (postorder[left] < postorder[end] && left < end) {
                    left++;
                }

                // 右树必须都大于根节点值
                for (int i = left; i < end; i++) {
                    if (postorder[i] < postorder[end]) {
                        return false;
                    }
                }

                // 继续判断左右树均为二叉搜索树
                return this.apply(from, left - 1) && this.apply(left, end - 1);
            }
        };

        return recursion.apply(0, len - 1);
    }
}
