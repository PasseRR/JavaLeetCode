package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 1000
 * @author xiehai
 * @date 2020/07/04 15:44
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof25 {
    // #region snippet
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0), l1c = l1, l2c = l2, cursor = node;

        while (l1c != null && l2c != null) {
            // 比较两个链表数值 移动较小的数值到头节点
            if (l1c.val < l2c.val) {
                cursor.next = new ListNode(l1c.val);
                l1c = l1c.next;
            } else {
                cursor.next = new ListNode(l2c.val);
                l2c = l2c.next;
            }

            cursor = cursor.next;
        }

        // 两个链表剩余部分
        cursor.next = l1c != null ? l1c : l2c;

        return node.next;
    }
    // #endregion snippet
}
