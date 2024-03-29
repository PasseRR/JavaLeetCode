package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.ListNode;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 * 注意：本题与主站 445题相同：https://leetcode.cn/problems/add-two-numbers-ii/
 * @author xiehai
 * @date 2022/01/06 17:25
 */
public class Lcof025 {
    // #region snippet
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode c1 = l1, c2 = l2;
        // 数字长度遍历
        while (c1 != null) {
            c1 = c1.next;
            len1++;
        }
        while (c2 != null) {
            c2 = c2.next;
            len2++;
        }

        // 指针重置
        c1 = l1;
        c2 = l2;
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        // 按照位数对应
        while (len1 > len2) {
            stack.push(c1.val);
            c1 = c1.next;
            len1--;
        }
        while (len2 > len1) {
            stack.push(c2.val);
            c2 = c2.next;
            len2--;
        }

        // 剩余数字相加
        while (len1 > 0) {
            stack.push(c1.val + c2.val);
            c1 = c1.next;
            c2 = c2.next;
            len1--;
        }

        ListNode r = new ListNode(0);
        // 节点追加方法
        Consumer<Integer> append = val -> {
            ListNode t = new ListNode(val);
            t.next = r.next;
            r.next = t;
        };

        // 进位
        int carry = 0;
        while (!stack.isEmpty()) {
            int val = stack.pop() + carry;
            carry = val / 10;
            val %= 10;
            append.accept(val);
        }

        // 最后还剩余进位
        if (carry > 0) {
            append.accept(carry);
        }

        return r.next;
    }
    // #endregion snippet
}
