package com.gitee.passerr.leetcode.problem.algorithm.page1;

import com.gitee.passerr.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * @author xiehai
 * @date 2019/07/03 13:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution19 {
    // #region snippet
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        // 节点缓存
        Map<Integer, ListNode> cache = new HashMap<>(8);
        ListNode cursor = head;
        while (Objects.nonNull(cursor)) {
            cache.put(++count, cursor);
            cursor = cursor.next;
        }

        // 移除节点索引
        int index = count - n + 1;
        // 移除头结点 若只有一个节点 头尾节点是同一个
        if (index == 1) {
            head = count == 1 ? null : head.next;
        } else if (index == count) {
            cache.get(index - 1).next = null;
        } else {
            // 移除中间节点
            cache.get(index - 1).next = cache.get(index + 1);
        }

        return head;
    }
    // #endregion snippet
}
