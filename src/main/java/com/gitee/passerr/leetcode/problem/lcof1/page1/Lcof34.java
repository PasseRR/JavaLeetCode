package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * |         5
 * |        / \
 * |       4   8
 * |      /   / \
 * |     11  13  4
 * |    /  \    / \
 * |   7    2  5   1
 * 返回:
 * |[
 * |   [5,4,11,2],
 * |   [5,8,4,5]
 * |]
 * <p>
 * 提示：
 * 节点总数 <= 10000
 * @author xiehai
 * @date 2020/07/04 16:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        // 缓存累加值
        AtomicInteger count = new AtomicInteger();

        BiConsumer<TreeNode, Stack<Integer>> backtrack = new BiConsumer<TreeNode, Stack<Integer>>() {
            @Override
            public void accept(TreeNode node, Stack<Integer> stack) {
                if (node == null) {
                    return;
                }
                // 栈存储每个节点值
                stack.push(node.val);
                count.addAndGet(node.val);
                // 满足条件的叶子节点
                if (node.left == null && node.right == null && count.get() == sum) {
                    result.add(new ArrayList<>(stack));
                }

                this.accept(node.left, stack);
                this.accept(node.right, stack);
                // 回溯并计算累加值
                count.addAndGet(-stack.pop());
            }
        };

        backtrack.accept(root, new Stack<>());

        return result;
    }
}
