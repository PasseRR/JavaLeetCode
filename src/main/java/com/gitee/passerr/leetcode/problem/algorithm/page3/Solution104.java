package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * @author xiehai
 * @date 2019/07/25 17:13
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        // 递归
        return root == null ? 0 : 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }
}
