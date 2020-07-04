package com.gitee.passerr.leetcode.problem.lcof.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @author xiehai
 * @date 2020/07/04 15:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cursor = head;
        // 计算节点数量
        int len = 0;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }

        int n = len - k;
        cursor = head;
        // 找到倒数第k个节点
        while (cursor != null && n > 0) {
            cursor = cursor.next;
            n--;
        }

        return cursor;
    }
}
