package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.Function;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * @author xiehai
 * @date 2020/06/06 15:39
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page3.Solution110
 */
public class Lcci0404 {
    public boolean isBalanced(TreeNode root) {
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
