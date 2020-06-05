package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 示例 2:
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * @author xiehai
 * @date 2019/08/01 13:59
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        BiConsumer<TreeNode, Integer> recursion = new BiConsumer<TreeNode, Integer>() {
            @Override
            public void accept(TreeNode node, Integer sum) {
                int value = sum * 10 + node.val;
                // 若是叶子节点
                if (node.left == null && node.right == null) {
                    result.add(value);
                    return;
                }

                if (node.left != null) {
                    this.accept(node.left, value);
                }

                if (node.right != null) {
                    this.accept(node.right, value);
                }
            }
        };

        recursion.accept(root, 0);

        return result.stream().mapToInt(Integer::intValue).sum();
    }
}
