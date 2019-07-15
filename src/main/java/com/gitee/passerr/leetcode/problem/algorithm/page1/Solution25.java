package com.gitee.passerr.leetcode.problem.algorithm.page1;

import com.gitee.passerr.leetcode.problem.algorithm.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author xiehai
 * @date 2019/07/04 11:05
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        // 缓存每一段待翻转的链表
        ListNode pending = new ListNode(0);
        // 待翻转链表指针
        ListNode pendingCursor = pending;
        // 翻转后的链表前置节点
        ListNode previous;
        // 翻转后的链表后继节点
        ListNode next;
        // 临时缓存head
        ListNode node;

        // 结果链表
        ListNode result = new ListNode(0);
        ListNode resultCursor = result;
        int count = 0;
        while (head != null) {
            node = head;
            // 缓存到待翻转链表
            count++;
            head = head.next;
            node.next = null;
            pendingCursor.next = node;
            pendingCursor = pendingCursor.next;

            if (count == k) {
                count = 0;
                pendingCursor = pending.next;
                // 将待翻转链表翻转并加入结果链表
                previous = null;
                // 翻转链表
                while (pendingCursor != null) {
                    next = pendingCursor.next;
                    pendingCursor.next = previous;
                    previous = pendingCursor;
                    pendingCursor = next;
                }

                // 将翻转后的链表添加到result链表中并移动指针到最后一个节点
                resultCursor.next = previous;
                int i = 0;
                while (i++ < k) {
                    resultCursor = resultCursor.next;
                }

                // 置空待翻转链表 遍历指针指向头结点
                pending.next = null;
                pendingCursor = pending;
            }
        }

        // 剩余节点保留原有顺序
        if (count > 0) {
            resultCursor.next = pending.next;
        }

        return result.next;
    }
}
