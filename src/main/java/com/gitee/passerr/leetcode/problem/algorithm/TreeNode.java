package com.gitee.passerr.leetcode.problem.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 二叉树节点
 * @author xiehai
 * @date 2019/07/23 11:19
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
            Objects.equals(left, treeNode.left) &&
            Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(this);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                if (node.left != null || node.right != null) {
                    deque.offer(node.left);
                    deque.offer(node.right);
                }
            } else {
                sb.append("null").append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}
