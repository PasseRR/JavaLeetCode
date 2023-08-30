package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * @author xiehai
 * @date 2019/08/01 09:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution114 {
    // #region snippet
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        // 递归左树
        this.flatten(left);
        // 递归右树
        this.flatten(right);
        // 左树直接拼接到右树
        if (null != left) {
            root.right = left;
        }
        // 若右树存在 拼接在当前右树后面
        if (null != right) {
            TreeNode cursor = root;
            while (cursor.right != null) {
                cursor = cursor.right;
            }
            cursor.right = right;
        }
    }
    // #endregion snippet
}
