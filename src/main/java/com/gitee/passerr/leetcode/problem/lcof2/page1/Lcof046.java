package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1,3,4]
 * <p>
 * 示例 2:
 * 输入:[1,null,3]
 * 输出:[1,3]
 * <p>
 * 示例 3:
 * 输入:[]
 * 输出:[]
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100<= Node.val <= 100
 * <p>
 * 注意：本题与主站 199题相同：https://leetcode.cn/problems/binary-tree-right-side-view/
 * @author xiehai
 * @date 2022/01/17 11:32
 */
public class Lcof046 {
    // #region snippet
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 层序遍历队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 根节点为空不入队
        if (Objects.nonNull(root)) {
            queue.offer(root);
        }

        int size;
        TreeNode t;
        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                t = queue.poll();
                // 队列尾部为每层最右侧元素
                if (i == size - 1) {
                    result.add(t.val);
                }

                // 左右树入队
                if (Objects.nonNull(t.left)) {
                    queue.offer(t.left);
                }
                if (Objects.nonNull(t.right)) {
                    queue.offer(t.right);
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
