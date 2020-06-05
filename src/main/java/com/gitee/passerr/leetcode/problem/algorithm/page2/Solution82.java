package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @author xiehai
 * @date 2019/07/19 16:20
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        // 前一个数字及计数
        int previous = head.val, count = 1;

        ListNode node = new ListNode(0);
        ListNode cursor = node;

        // 遍历链表
        while ((head = head.next) != null) {
            if (previous == head.val) {
                // 和当前数字相同 计数
                count++;
            } else {
                // 当前位置数字和前一个数字不同 且前一个数字计数为1 加入到链表中
                if (count == 1) {
                    cursor.next = new ListNode(previous);
                    cursor = cursor.next;
                }
                // 记录新数字
                previous = head.val;
                count = 1;
            }
        }

        // 最后一个非重复数字
        if (count == 1) {
            cursor.next = new ListNode(previous);
        }

        return node.next;
    }
}
