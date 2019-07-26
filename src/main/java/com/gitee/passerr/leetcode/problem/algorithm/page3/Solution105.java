package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @author xiehai
 * @date 2019/07/25 17:23
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序第一个节点为根节点
        TreeNode root = new TreeNode(preorder[0]);
        return root;
    }
}
