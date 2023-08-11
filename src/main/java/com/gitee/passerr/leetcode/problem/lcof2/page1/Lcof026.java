package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * <p>
 * 示例 2:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 5 * 10<sup>4</sup>]
 * 1 <= node.val <= 1000
 * <p>
 * 注意：本题与主站 143题相同：https://leetcode.cn/problems/reorder-list/
 * @author xiehai
 * @date 2022/01/07 10:15
 */
public class Lcof026 {
    public void reorderList(ListNode head) {
        // 使用快慢指针找链表中点
        ListNode slow = new ListNode(0, head), fast = new ListNode(0, head);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 待倒叙的链表
        ListNode mid = slow.next;
        // 顺序链表后置空
        slow.next = null;
        ListNode reverse = new ListNode(0), t;
        // 将后半部分链表倒置
        while (mid != null) {
            t = mid.next;
            mid.next = reverse.next;
            reverse.next = mid;
            mid = t;
        }

        // 根据题意 顺序链表肯定长度大于(节点数位奇数的时候大于)等于倒叙链表
        reverse = reverse.next;
        // 交叉合并两个链表
        while (reverse != null) {
            t = head.next;
            head.next = reverse;
            reverse = reverse.next;
            head.next.next = t;
            head = t;
        }
    }
}
