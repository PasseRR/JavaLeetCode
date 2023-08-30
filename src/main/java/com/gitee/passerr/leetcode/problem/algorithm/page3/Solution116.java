package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.Node;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 示例：
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * @author xiehai
 * @date 2019/07/31 17:02
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution116 {
    // #region snippet
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        // 拼接当前节点左右节点
        root.left.next = root.right;
        // 如果当前根节点存在下一个节点 将当前右节点与下一节点左节点拼接
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        // 递归拼接左树
        this.connect(root.left);
        // 递归拼接右树
        this.connect(root.right);

        return root;
    }
    // #endregion snippet
}
