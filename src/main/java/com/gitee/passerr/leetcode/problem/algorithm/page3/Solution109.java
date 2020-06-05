package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.ListNode;
import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @author xiehai
 * @date 2019/07/31 14:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution108
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 链表转数组
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        BiFunction<Integer, Integer, TreeNode> recursion = new BiFunction<Integer, Integer, TreeNode>() {
            @Override
            public TreeNode apply(Integer begin, Integer end) {
                if (begin > end) {
                    return null;
                }
                // 取中间节点为根节点
                int mid = (begin + end) / 2;
                TreeNode node = new TreeNode(list.get(mid));
                // 递归生成左树
                node.left = this.apply(begin, mid - 1);
                // 递归生成右树
                node.right = this.apply(mid + 1, end);
                return node;
            }
        };

        return list.size() == 0 ? null : recursion.apply(0, list.size() - 1);
    }
}
