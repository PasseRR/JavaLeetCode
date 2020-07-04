package com.gitee.passerr.leetcode.problem.lcof.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回：
 * [3,9,20,15,7]
 *  
 * 提示：
 * 节点总数 <= 1000
 * @author xiehai
 * @date 2020/07/04 16:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof32I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        // 队列添加根节点
        Queue<TreeNode> queue = new ArrayDeque<>(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            // 由左至右 先添加左节点 在添加右节点
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
