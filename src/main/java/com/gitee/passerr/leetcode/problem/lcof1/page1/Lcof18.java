package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * @author xiehai
 * @date 2020/07/04 15:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cursor = head, previous = null;
        while (cursor.val != val) {
            previous = cursor;
            cursor = cursor.next;
        }

        // 若存在前驱节点
        if (previous != null) {
            previous.next = cursor.next;
        }

        // 若存在前驱节点 则返回头结点 否则说明头结点值为val 返回头结点后一节点
        return previous == null ? head.next : head;
    }
}
