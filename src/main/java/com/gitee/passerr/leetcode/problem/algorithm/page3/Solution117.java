package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.Node;

/**
 * 给定一个二叉树
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
 * @date 2019/07/31 18:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution116
 */
public class Solution117 {
    // #region snippet
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // 拼接当前节点子节点 得到未拼接next的节点
        Node previous;
        // 若左右节点都存在 则拼接左右节点 并且待拼接节点为右节点
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            previous = root.right;
        } else {
            // 若子节点存在null节点 则待拼接节点为非null那个节点
            previous = root.left != null ? root.left : root.right;
        }

        // 拼接前一节点和后一节点
        // next节点存在多个 可能存在next节点无子节点 遍历直到next存在子节点或next为null
        // 优先选next的左节点 若左节点为null 选择右节点 若右节点为null 则前一节点没有next
        Node next = root.next;
        while (next != null && next.left == null && next.right == null) {
            next = next.next;
        }
        if (null != next) {
            previous.next = next.left != null ? next.left : next.right;
        }

        // 递归拼接左右树
        // 先拼接右树 再拼接左树
        // 保证右树的next节点拼接 再用左节点拼接
        this.connect(root.right);
        this.connect(root.left);

        return root;
    }
    // #endregion snippet
}
