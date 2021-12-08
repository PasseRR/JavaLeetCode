package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * |
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回其层次遍历结果：
 * |
 * |[
 * |  [3],
 * |  [9,20],
 * |  [15,7]
 * |]
 * <p>
 * 提示：
 * 节点总数 <= 1000
 * @author xiehai
 * @date 2020/07/04 16:14
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Optional.ofNullable(root).ifPresent(queue::add);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 队列中为上一层的数字 遍历开始前记录总数
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
