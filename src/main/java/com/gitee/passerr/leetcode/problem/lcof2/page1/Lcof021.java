package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：能尝试使用一趟扫描实现吗？
 * 注意：本题与主站 19题相同：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author xiehai
 * @date 2022/01/06 10:07
 */
public class Lcof021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 缓存位置及节点
        ListNode[] nodes = new ListNode[30];

        ListNode cursor = head;
        // 节点数量
        int cnt = 0;
        while (cursor != null) {
            nodes[cnt++] = cursor;
            cursor = cursor.next;
        }

        // 只有一个节点
        if (cnt == 1) {
            return null;
        }

        if (n == cnt) {
            // 头结点
            head = head.next;
        } else if (n == 1) {
            // 最后一个节点 将尾节点置空
            nodes[cnt - 2].next = null;
        } else {
            // 中间节点
            nodes[cnt - n - 1].next = nodes[cnt - n + 1];
        }

        return head;
    }
}
