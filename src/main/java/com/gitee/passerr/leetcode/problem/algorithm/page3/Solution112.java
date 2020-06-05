package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @author xiehai
 * @date 2019/07/31 16:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 兼容null树
        if (root == null) {
            return false;
        }

        // 如果为叶子节点 判断是否满足和相等
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        // 递归计算左右树的和
        return this.hasPathSum(root.left, sum - root.val) || this.hasPathSum(root.right, sum - root.val);
    }
}
