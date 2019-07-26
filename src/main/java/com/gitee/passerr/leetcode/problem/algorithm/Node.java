package com.gitee.passerr.leetcode.problem.algorithm;

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
    public Node next;

    public Node() {
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
