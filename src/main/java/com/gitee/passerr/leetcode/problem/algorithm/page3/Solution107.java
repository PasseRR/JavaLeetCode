package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author xiehai
 * @date 2019/07/31 11:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution102
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 按照层级缓存数字
        Map<Integer, List<Integer>> cache = new HashMap<>(8);

        BiConsumer<TreeNode, Integer> recursion = new BiConsumer<TreeNode, Integer>() {
            @Override
            public void accept(TreeNode node, Integer layer) {
                if (null == node) {
                    return;
                }
                // 将数字加入对应层级
                cache.merge(layer, new ArrayList<>(Collections.singletonList(node.val)), (o, n) -> {
                    o.add(node.val);

                    return o;
                });
                // 遍历左树
                this.accept(node.left, layer + 1);
                // 遍歷右樹
                this.accept(node.right, layer + 1);
            }
        };
        recursion.accept(root, 0);

        return cache.keySet().stream().sorted(Comparator.reverseOrder()).map(cache::get).collect(Collectors.toList());
    }
}
