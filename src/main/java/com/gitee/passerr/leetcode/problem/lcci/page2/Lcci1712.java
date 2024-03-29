package com.gitee.passerr.leetcode.problem.lcci.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.Consumer;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，
 * 要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 提示：
 * 节点数量不会超过 100000。
 * @author xiehai
 * @date 2021/05/18 11:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1712 {
    // #region snippet
    public TreeNode convertBiNode(TreeNode root) {
        // previous.right为前置节点及结果
        final TreeNode previous = new TreeNode(0), result = new TreeNode(0);
        // 中序遍历
        Consumer<TreeNode> inorderTraversal = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                if (previous.right == null) {
                    // 前置节点为空时 左树最小节点即头结点
                    // 设置结果节点
                    result.right = node;
                    // 下一个前置节点
                    previous.right = node;
                } else {
                    // 下下个前置节点
                    previous.right.right = node;
                    // 下一个前置节点
                    previous.right = previous.right.right;
                }
                // 清空左树
                node.left = null;
                this.accept(node.right);
            }
        };

        inorderTraversal.accept(root);

        return result.right;
    }
    // #endregion snippet
}
