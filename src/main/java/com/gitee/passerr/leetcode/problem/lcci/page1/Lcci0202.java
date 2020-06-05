package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * 给定的 k 保证是有效的。
 * @author xiehai
 * @date 2020/06/05 16:34
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0202 {
    public int kthToLast(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        // 计算链表长度
        while (node != null) {
            count++;
            node = node.next;
        }

        int i = 0;
        node = head;
        // 找到倒数k位置的数字
        while (node != null) {
            if (i + k == count) {
                return node.val;
            }
            node = node.next;
            i++;
        }

        return 0;
    }
}
