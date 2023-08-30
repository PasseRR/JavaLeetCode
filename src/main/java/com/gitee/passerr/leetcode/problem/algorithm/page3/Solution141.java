package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * @author xiehai
 * @date 2019/08/08 16:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution141 {
    // #region snippet
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 利用快慢指针 若两指针相同 则有环 否则无环
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
    // #endregion snippet
}
