package com.gitee.passerr.leetcode.problem.algorithm.page1;

import com.gitee.passerr.leetcode.ListNode;

import java.util.Objects;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author xiehai
 * @date 2019/06/28 16:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 结果链表 初始化了个头 返回时去掉头
        ListNode result = new ListNode(0);
        // 当前游标
        ListNode cursor = result;
        // 进位标志
        int carry = 0;

        // 两个数字有一个还未计算完或存在进位
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || carry > 0) {
            // 计算和 若其中一个高位不存在用0代替 加上上一轮的进位
            int sum = (Objects.isNull(l1) ? 0 : l1.val) + (Objects.isNull(l2) ? 0 : l2.val) + carry;
            // 结果为取余
            cursor.next = new ListNode(sum % 10);
            // 进位
            carry = sum / 10;
            l1 = Objects.isNull(l1) ? null : l1.next;
            l2 = Objects.isNull(l2) ? null : l2.next;
            // 游标移动
            cursor = cursor.next;
        }


        return result.next;
    }
}
