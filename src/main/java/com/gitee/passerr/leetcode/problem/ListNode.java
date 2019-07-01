package com.gitee.passerr.leetcode.problem;

import java.util.Objects;

/**
 * 链表节点
 * @author xiehai
 * @date 2019/06/28 16:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 快速构造链表
     * @param values 链表值
     * @return {@link ListNode}
     */
    public static ListNode of(int... values) {
        Objects.requireNonNull(values);

        ListNode node = new ListNode(0);
        ListNode cursor = node;
        for (int val : values) {
            cursor.next = new ListNode(val);
            cursor = cursor.next;
        }

        return node.next;
    }

    @Override
    public String toString() {
        ListNode cursor = this;
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(cursor)) {
            sb.append("->").append(cursor.val);
            cursor = cursor.next;
        }

        return sb.substring(2);
    }
}