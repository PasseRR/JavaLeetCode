package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 * @author xiehai
 * @date 2020/06/05 16:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0204 {
    public ListNode partition(ListNode head, int x) {
        // 小于x部分
        ListNode left = new ListNode(0);
        // 左指针
        ListNode leftCursor = left;
        // 大于x部分
        ListNode right = new ListNode(0);
        // 右指针
        ListNode rightCursor = right;
        while (head != null) {
            if (head.val < x) {
                leftCursor.next = new ListNode(head.val);
                leftCursor = leftCursor.next;
            } else {
                rightCursor.next = new ListNode(head.val);
                rightCursor = rightCursor.next;
            }
            head = head.next;
        }
        // 拼接左右链表
        leftCursor.next = right.next;

        return left.next;
    }
}
