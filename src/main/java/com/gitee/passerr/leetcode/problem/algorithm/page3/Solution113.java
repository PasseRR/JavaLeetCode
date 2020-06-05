package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * @author xiehai
 * @date 2019/07/31 16:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        // 递归求解
        TrConsumer<TreeNode, List<Integer>, Integer> recursion = new TrConsumer<TreeNode, List<Integer>, Integer>() {
            @Override
            public void accept(TreeNode node, List<Integer> list, Integer s) {
                if (node == null) {
                    return;
                }

                // 若是叶子节点
                if (node.left == null && node.right == null) {
                    // 满足路径和
                    if (s == node.val) {
                        list.add(node.val);
                        result.add(list);
                    }
                } else {
                    list.add(node.val);
                    // 递归累减左右树
                    this.accept(node.left, new ArrayList<>(list), s - node.val);
                    this.accept(node.right, new ArrayList<>(list), s - node.val);
                }
            }
        };

        recursion.accept(root, new ArrayList<>(), sum);

        return result;
    }

    private interface TrConsumer<T, U, P> {
        void accept(T t, U u, P p);
    }
}
