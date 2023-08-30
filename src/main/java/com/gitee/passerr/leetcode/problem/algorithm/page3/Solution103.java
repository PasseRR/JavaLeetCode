package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @author xiehai
 * @date 2019/07/25 16:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution102
 */
public class Solution103 {
    // #region snippet
    @SuppressWarnings("unchecked")
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        BiConsumer<TreeNode, Integer> recursion = new BiConsumer<TreeNode, Integer>() {
            @Override
            public void accept(TreeNode node, Integer layer) {
                if (null == node) {
                    return;
                }
                if (result.size() < layer + 1) {
                    result.add(new LinkedList<>());
                }
                // 将数字加入对应层级
                // 根据层级奇偶性进行锯齿形变换
                if (layer % 2 == 0) {
                    ((LinkedList) result.get(layer)).addLast(node.val);
                } else {
                    ((LinkedList) result.get(layer)).addFirst(node.val);
                }
                // 遍历左树
                this.accept(node.left, layer + 1);
                // 遍历右樹
                this.accept(node.right, layer + 1);
            }
        };
        recursion.accept(root, 0);

        return result;
    }
    // #endregion snippet
}
