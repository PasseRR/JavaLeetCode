package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * 输出: false
 * @author xiehai
 * @date 2019/07/23 11:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return
            // 其中一个节点为null
            p == null || q == null
                // 判断是否都为null
                ? p == q
                // 比较当前节点值及递归比较左右节点是否一致
                : p.val == q.val && this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }
}
