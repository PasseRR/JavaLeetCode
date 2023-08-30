package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * @author xiehai
 * @date 2020/07/04 14:28
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof06 {
    // #region snippet
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cursor = head;
        // 获取链表长度
        while (cursor != null) {
            cursor = cursor.next;
            count++;
        }

        int[] result = new int[count];
        // 重置指针
        cursor = head;
        // 倒叙设置数组值
        while (cursor != null) {
            result[--count] = cursor.val;
            cursor = cursor.next;
        }

        return result;
    }
    // #endregion snippet
}
