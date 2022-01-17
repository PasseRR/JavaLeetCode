package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * |    1
 * |   / \
 * |  3   2
 * | / \   \
 * |5   3   9
 * <p>
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 * |  1
 * | / \
 * |2   3
 * <p>
 * 示例3：
 * 输入: root = [1]
 * 输出: [1]
 * <p>
 * 示例4：
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 * |1
 * | \
 * |  2
 * <p>
 * 示例5：
 * 输入: root = []
 * 输出: []
 * <p>
 * 提示：
 * 二叉树的节点个数的范围是 [0,10<sup>4</sup>]
 * -2<sup>31</sup><= Node.val <= 2<sup>31</sup> - 1
 * <p>
 * 注意：本题与主站515题相同：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @author xiehai
 * @date 2022/01/17 10:49
 */
public class Lcof044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        // 若根节点非空 则入队
        if (Objects.nonNull(root)) {
            queue.offer(root);
        }

        int max, size;
        TreeNode t;
        while (!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            size = queue.size();

            // 按照当前队列大小遍历
            for (int i = 0; i < size; i++) {
                t = queue.poll();
                // 迭代最大值
                max = Integer.max(t.val, max);

                // 左右树非空则入队
                if (Objects.nonNull(t.left)) {
                    queue.offer(t.left);
                }
                if (Objects.nonNull(t.right)) {
                    queue.offer(t.right);
                }
            }

            result.add(max);
        }


        return result;
    }
}
