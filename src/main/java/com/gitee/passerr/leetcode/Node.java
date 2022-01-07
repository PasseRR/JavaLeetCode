package com.gitee.passerr.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 二叉树节点
 * @author xiehai
 * @date 2019/07/26 14:01
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node prev;
    public Node next;
    public Node random;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return val == node.val
            && Objects.equals(left, node.left)
            && Objects.equals(right, node.right)
            && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Deque<Node> deque = new LinkedList<>();
        deque.addLast(this);
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            if (node != null) {
                sb.append(node.val)
                    .append("(")
                    .append(node.next == null ? "null" : node.next.val)
                    .append(")")
                    .append(",");
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
