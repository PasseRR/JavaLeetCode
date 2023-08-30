package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @author xiehai
 * @date 2019/07/19 17:45
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution83 {
    // #region snippet
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = new ListNode(0);
        ListNode cursor = node;
        // 初始化为头结点的值
        cursor.next = new ListNode(head.val);

        while ((head = head.next) != null) {
            // 仅当当前节点值不与cursor.next值一样时 增加链表节点
            if (cursor.next.val != head.val) {
                cursor = cursor.next;
                cursor.next = new ListNode(head.val);
            }
        }

        return node.next;
    }
    // #endregion snippet
}
