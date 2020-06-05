package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @author xiehai
 * @date 2019/08/08 15:41
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        // 少于2个节点 不需要重写排列
        if (head == null || head.next == null) {
            return;
        }

        // 使用快慢指针获取中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 中间点
        ListNode pivot = slow;
        // slow向后一个节点就是需要反转的链表
        slow = slow.next;
        // 置空中间点后置节点
        pivot.next = null;

        // 翻转中间之后的链表
        ListNode reverse = null, next;
        // 链表翻转
        while (slow != null) {
            next = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = next;
        }

        // 顺序链表游标、顺序链表后置节点、倒叙链表后置节点
        ListNode cursor = head, hn, rn;
        // 拼接顺序链表和倒叙链表
        while (cursor != null && reverse != null) {
            // 顺序链表后置节点
            hn = cursor.next;
            // 倒叙链表后置节点
            rn = reverse.next;
            // 拼接倒叙链表
            cursor.next = reverse;
            // 设置后置节点
            cursor.next.next = hn;
            // 两个链表移动
            cursor = hn;
            reverse = rn;
        }
    }
}
