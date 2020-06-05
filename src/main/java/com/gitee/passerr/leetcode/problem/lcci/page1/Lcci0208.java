package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * @author xiehai
 * @date 2020/06/05 16:57
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0208 {
    public ListNode detectCycle(ListNode head) {
        // 少于2个节点 直接返回
        if (head == null || head.next == null) {
            return null;
        }
        // 使用快慢针比较 若存在循环 会一直遍历直到存在相同地址的节点
        // 若其中一个节点为null 则表示不存在环
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 没有环
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // 相遇表示有环 且是环中的某个点
        fast = head;
        slow = slow.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }


        return fast;
    }
}
