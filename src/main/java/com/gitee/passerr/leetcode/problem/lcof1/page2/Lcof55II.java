package com.gitee.passerr.leetcode.problem.lcof1.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.Function;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * |       1
 * |      / \
 * |     2   2
 * |    / \
 * |   3   3
 * |  / \
 * | 4   4
 * 返回 false 。
 * <p>
 * 限制：
 * 1 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author xiehai
 * @date 2020/07/14 16:27
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof55II {
    public boolean isBalanced(TreeNode root) {
        // 递归获取树的最大深度
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
