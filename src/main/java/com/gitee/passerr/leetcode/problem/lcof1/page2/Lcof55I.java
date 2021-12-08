package com.gitee.passerr.leetcode.problem.lcof1.page2;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回它的最大深度 3 。
 * <p>
 * 提示：
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author xiehai
 * @date 2020/07/14 16:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof55I {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}
