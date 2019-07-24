package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *    / \
 *   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author xiehai
 * @date 2019/07/23 13:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution98 {
    /**
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     * @param root 根节点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 中序遍历树
        Consumer<TreeNode> inorderTraversal = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                list.add(node.val);
                this.accept(node.right);
            }
        };
        inorderTraversal.accept(root);

        // 若中序遍历结果是升序的 则是二叉搜索树 否则不是
        for (int i = 1, length = list.size(); i < length; i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }
}
