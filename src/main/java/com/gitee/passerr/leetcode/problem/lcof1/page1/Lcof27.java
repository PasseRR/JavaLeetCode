package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * |     4
 * |   /   \
 * |  2     7
 * | / \   / \
 * |1   3 6   9
 * 镜像输出：
 * |     4
 * |   /   \
 * |  7     2
 * | / \   / \
 * |9   6 3   1
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 1000
 * @author xiehai
 * @date 2020/07/04 15:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof27 {
    // #region snippet
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode mirror = new TreeNode(root.val);
        mirror.right = this.mirrorTree(root.left);
        mirror.left = this.mirrorTree(root.right);

        return mirror;
    }
    // #endregion snippet
}
