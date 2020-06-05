package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author xiehai
 * @date 2019/08/07 09:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 递归遍历
        Consumer<TreeNode> preOrder = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                result.add(node.val);
                this.accept(node.left);
                this.accept(node.right);
            }
        };
        preOrder.accept(root);

        return result;
    }
}
