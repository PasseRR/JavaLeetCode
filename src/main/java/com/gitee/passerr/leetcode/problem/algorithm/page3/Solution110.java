package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.Function;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * @author xiehai
 * @date 2019/07/31 14:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        Function<TreeNode, Integer> recursion = new Function<TreeNode, Integer>() {
            @Override
            public Integer apply(TreeNode node) {
                return node == null ? 0 : Math.max(this.apply(node.left), this.apply(node.right)) + 1;
            }
        };

        return root == null || (
            // 高度差不能超过1
            Math.abs(recursion.apply(root.left) - recursion.apply(root.right)) <= 1
                // 左右树也是高度平衡二叉树
                && this.isBalanced(root.left) && this.isBalanced(root.right)
        );
    }
}
