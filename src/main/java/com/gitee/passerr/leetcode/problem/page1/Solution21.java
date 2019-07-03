package com.gitee.passerr.leetcode.problem.page1;

import com.gitee.passerr.leetcode.problem.ListNode;

import java.util.Objects;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author xiehai
 * @date 2019/07/03 15:08
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 头节点
        ListNode head = new ListNode(0);
        // 游标节点
        ListNode cursor = head;
        // 同长度部分
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val > l2.val) {
                cursor.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                cursor.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cursor = cursor.next;
        }

        // l1多余l2的部分
        while (Objects.nonNull(l1)) {
            cursor.next = new ListNode(l1.val);
            l1 = l1.next;
            cursor = cursor.next;
        }
        // l2多余l1的部分
        while (Objects.nonNull(l2)) {
            cursor.next = new ListNode(l2.val);
            l2 = l2.next;
            cursor = cursor.next;
        }

        return head.next;
    }
}
