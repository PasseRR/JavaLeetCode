package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
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
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author xiehai
 * @date 2020/06/06 15:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page2.Solution98
 */
public class Lcci0405 {
    // #region snippet
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
    // #endregion snippet
}
