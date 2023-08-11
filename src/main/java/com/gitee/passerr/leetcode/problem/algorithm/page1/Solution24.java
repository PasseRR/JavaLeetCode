package com.gitee.passerr.leetcode.problem.algorithm.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author xiehai
 * @date 2019/07/04 10:24
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 新链表
        ListNode result = new ListNode(0);
        // 新链表遍历指针
        ListNode cursor = result;

        while (null != head) {
            ListNode previous = head;
            ListNode next = head.next;
            // 节点数量为奇数
            if (null == next) {
                head = null;
            } else {
                // 头节点移动2位
                head = next.next;
                // 节点数量为偶数 交换节点
                // 将第二个节点移动到第一个
                // 置空后置节点
                next.next = null;
                cursor.next = next;
                cursor = cursor.next;
                // 将第一个节点移动到第二个
                // 置空后置节点
                previous.next = null;
            }
            cursor.next = previous;
            cursor = cursor.next;
        }

        return result.next;
    }
}
