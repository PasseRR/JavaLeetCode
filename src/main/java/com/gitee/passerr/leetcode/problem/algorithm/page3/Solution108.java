package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

import java.util.function.BiFunction;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @author xiehai
 * @date 2019/07/31 13:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        BiFunction<Integer, Integer, TreeNode> recursion = new BiFunction<Integer, Integer, TreeNode>() {
            @Override
            public TreeNode apply(Integer begin, Integer end) {
                if (begin > end) {
                    return null;
                }
                // 取中间节点为根节点
                int mid = (begin + end) / 2;
                TreeNode node = new TreeNode(nums[mid]);
                // 递归生成左树
                node.left = this.apply(begin, mid - 1);
                // 递归生成右树
                node.right = this.apply(mid + 1, end);
                return node;
            }
        };

        return nums.length == 0 ? null : recursion.apply(0, nums.length - 1);
    }
}
