package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * @author xiehai
 * @date 2019/07/31 15:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = this.minDepth(root.left);
        int right = this.minDepth(root.right);
        // 当左树或右树有一个为null时 最小深度为非空树深度
        // 当左右树均不为空时 最小深度为左右树较小深度
        return left == 0 || right == 0 ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
    }
}
