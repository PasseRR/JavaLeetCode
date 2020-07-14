package com.gitee.passerr.leetcode.problem.lcof.page1;

import com.gitee.passerr.leetcode.Node;

import java.util.function.Consumer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 注意：此题对比原题有改动。
 * @author xiehai
 * @date 2020/07/14 09:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof36 {
    public Node treeToDoublyList(Node root) {
        // left表示头结点 right表示尾节点
        Node result = new Node(0);
        // 使用中序遍历
        // 第一个节点为头结点 最后一个节点为尾节点
        Consumer<Node> recursion = new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                if (result.right == null) {
                    // 设置头结点位置
                    result.left = node;
                } else {
                    // 双指针当前节点和尾节点
                    result.right.right = node;
                    node.left = result.right;
                }
                // 设置最后访问的节点 即尾节点
                result.right = node;
                this.accept(node.right);
            }
        };

        recursion.accept(root);
        // 头、尾节点指针
        if (null != result.left) {
            result.left.left = result.right;
            result.right.right = result.left;
        }

        return result.left;
    }
}
