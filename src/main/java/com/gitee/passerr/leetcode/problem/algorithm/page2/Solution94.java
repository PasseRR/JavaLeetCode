package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author xiehai
 * @date 2019/07/24 11:23
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution94 {
    // #region snippet
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 递归实现
        Consumer<TreeNode> recursion = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                // 左中右顺序
                this.accept(node.left);
                result.add(node.val);
                this.accept(node.right);
            }
        };

        recursion.accept(root);

        return result;
    }
    // #endregion snippet
}
