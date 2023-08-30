package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author xiehai
 * @date 2019/08/07 09:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution147 {
    // #region snippet
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        while (head.next != null) {
            if (head.val > head.next.val) {
                ListNode previous = newHead;
                while (previous.next != null && previous.next.val < head.next.val) {
                    previous = previous.next;
                }

                ListNode next = previous.next;
                ListNode current = head.next;
                // 删除排序节点
                head.next = current.next;
                // 拼接
                current.next = next;
                // 插入排序节点
                previous.next = current;
                // 下一个节点继续和当前头节点比较
            } else {
                // 升序 继续遍历
                head = head.next;
            }
        }

        return newHead.next;
    }
    // #endregion snippet
}
