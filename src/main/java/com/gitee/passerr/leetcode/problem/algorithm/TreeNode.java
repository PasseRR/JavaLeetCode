package com.gitee.passerr.leetcode.problem.algorithm;

/**
 * 二叉树节点
 * @author xiehai
 * @date 2019/07/23 11:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
