package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author xiehai
 * @date 2019/07/24 11:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution92 {
    // #region snippet
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        // 当前链表游标
        ListNode cursor = head;
        // 新头结点
        ListNode newHead = new ListNode(0);
        // 新链表反转前部分游标
        ListNode newHeadCursor = newHead;
        int i = 1;
        // 找到反转开始前一个节点
        while (i < m) {
            newHeadCursor.next = new ListNode(cursor.val);
            newHeadCursor = newHeadCursor.next;
            cursor = cursor.next;
            i++;
        }

        // head指向反转开始节点
        ListNode reverseHead = null;
        // head反转尾节点
        ListNode reverseTail = null;
        // 反转中间部分链表
        while (i <= n) {
            ListNode temp = new ListNode(cursor.val);
            if (null == reverseTail) {
                reverseTail = temp;
            }
            temp.next = reverseHead;
            reverseHead = temp;
            cursor = cursor.next;
            i++;
        }

        // 源链表剩余部分追加
        if (null != reverseTail) {
            reverseTail.next = cursor;
        }

        // 反转前部分链表追加反转后的链表
        newHeadCursor.next = reverseHead;

        return newHead.next;
    }
    // #endregion snippet
}
