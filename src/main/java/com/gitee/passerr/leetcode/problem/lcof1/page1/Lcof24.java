package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author xiehai
 * @date 2020/07/04 15:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof24 {
    // #region snippet
    public ListNode reverseList(ListNode head) {
        // 头结点
        ListNode node = new ListNode(0);
        while (head != null) {
            // 新节点
            ListNode n = new ListNode(head.val);
            // 新节点后继节点指向头结点后继
            n.next = node.next;
            // 头结点后继指向新节点
            node.next = n;
            head = head.next;
        }

        return node.next;
    }
    // #endregion snippet
}
