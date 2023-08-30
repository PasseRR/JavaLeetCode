package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * @author xiehai
 * @date 2020/06/05 16:29
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0201 {
    // #region snippet
    public ListNode removeDuplicateNodes(ListNode head) {
        // 打表法
        boolean[] table = new boolean[20001];
        ListNode newHead = new ListNode(0);
        ListNode newNode = newHead;

        while (head != null) {
            if (!table[head.val]) {
                ListNode tmp = new ListNode(head.val);
                newNode.next = tmp;
                newNode = tmp;
                table[head.val] = true;
            }

            head = head.next;
        }

        return newHead.next;
    }
    // #endregion snippet
}
