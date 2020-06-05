package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @author xiehai
 * @date 2019/07/15 17:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        // 尾节点
        ListNode t = head;
        int count = 0;
        while (null != t) {
            t = t.next;
            count++;
        }
        // 节点数量为0或移动次数是节点数量整数倍 直接返回头结点
        if (0 == count || k % count == 0) {
            return head;
        }

        // 移动后n个节点至头部
        int offset = k % count;
        t = head;
        int index = 0;
        // 前半部分
        while (index++ < (count - offset - 1)) {
            t = t.next;
        }
        // 中间截断节点
        ListNode m = t;
        // 后半部分
        while (offset-- > 0) {
            t = t.next;
        }
        // 后半部分链接到头结点
        t.next = head;
        // 新的头结点
        ListNode newHead = m.next;
        // 新的尾节点
        m.next = null;

        return newHead;
    }
}
