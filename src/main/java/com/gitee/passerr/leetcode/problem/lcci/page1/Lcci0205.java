package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * <p>
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * @author xiehai
 * @date 2020/06/05 16:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page1.Solution2
 */
public class Lcci0205 {
    // #region snippet
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        int carry = 0;
        // 相同位数相加
        while (l1 != null && l2 != null) {
            // 数值相加 加上进位
            int sum = l1.val + l2.val + carry;
            // 节点值
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            // 保留进位
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1高位追加
        while (l1 != null) {
            // 数值相加 加上进位
            int sum = l1.val + carry;
            // 节点值
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            // 保留进位
            carry = sum / 10;
            l1 = l1.next;
        }

        // l2高位追加
        while (l2 != null) {
            // 数值相加 加上进位
            int sum = l2.val + carry;
            // 节点值
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            // 保留进位
            carry = sum / 10;
            l2 = l2.next;
        }

        // 剩余进位追加
        if (carry > 0) {
            cursor.next = new ListNode(carry);
        }

        return head.next;
    }
    // #endregion snippet
}
