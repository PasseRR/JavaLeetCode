package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author xiehai
 * @date 2019/08/07 17:51
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        // 当链表只有一个节点时 就是有序的
        if (head == null || head.next == null) {
            return head;
        }

        // 归并排序
        // 快慢指针遍历出中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表分割成两部分
        ListNode right = this.sortList(slow.next);
        slow.next = null;
        ListNode left = this.sortList(head);

        ListNode node = new ListNode(0);
        ListNode cursor = node;
        // 合并两个链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                cursor.next = left;
                left = left.next;
            } else {
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }

        cursor.next = left != null ? left : right;

        return node.next;
    }
}
