package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * <p>
 * 示例 2:
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * <p>
 * 进阶:
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * @author xiehai
 * @date 2019/07/23 11:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        // 中序遍历树
        Consumer<TreeNode> inorderTraversal = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                list.add(node);
                this.accept(node.right);
            }
        };
        inorderTraversal.accept(root);

        TreeNode first = null, second = null;
        // 找到中序遍历节点中降序节点
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (first == null) {
                    // 第一个降序
                    first = list.get(i - 1);
                    second = list.get(i);
                } else {
                    // 第二个降序
                    second = list.get(i);
                }
            }
        }

        // 交换节点值
        first.val ^= second.val;
        second.val ^= first.val;
        first.val ^= second.val;
    }
}
