package com.gitee.passerr.leetcode.problem.lcof1.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * |   3
 * |  / \
 * | 1   4
 * |  \
 * |   2
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * |       5
 * |      / \
 * |     3   6
 * |    / \
 * |   2   4
 * |  /
 * | 1
 * 输出: 4
 * <p>
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * @author xiehai
 * @date 2020/07/14 16:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof54 {
    // #region snippet
    public int kthLargest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        // 中序遍历树
        Consumer<TreeNode> inorderTraversal = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                nums.add(node.val);
                this.accept(node.right);
            }
        };
        inorderTraversal.accept(root);

        // 获取倒数位置数字
        return nums.get(nums.size() - k);
    }
    // #endregion snippet
}
