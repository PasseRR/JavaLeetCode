package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @author xiehai
 * @date 2019/07/22 16:29
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution86 {
    // #region snippet
    public ListNode partition(ListNode head, int x) {
        // 小于x的头结点
        ListNode lessThanX = new ListNode(0);
        // 小于x链表游标
        ListNode lessThanXCursor = lessThanX;
        // 大于等于x的头结点
        ListNode greaterThanX = new ListNode(0);
        // 大于等于x链表游标
        ListNode greaterThanXCursor = greaterThanX;

        // 遍历源链表
        while (head != null) {
            if (head.val < x) {
                lessThanXCursor.next = new ListNode(head.val);
                lessThanXCursor = lessThanXCursor.next;
            } else {
                greaterThanXCursor.next = new ListNode(head.val);
                greaterThanXCursor = greaterThanXCursor.next;
            }
            head = head.next;
        }

        // 拼接链表
        lessThanXCursor.next = greaterThanX.next;

        return lessThanX.next;
    }
    // #endregion snippet
}
