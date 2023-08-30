package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.ListNode;

import java.util.function.BiFunction;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 注意：本题与主站 206题相同：https://leetcode.cn/problems/reverse-linked-list/
 * @author xiehai
 * @date 2022/01/06 14:03
 */
public class Lcof024 {
    // #region snippet
    public ListNode reverseList(ListNode head) {
        // 递归法
        BiFunction<ListNode, ListNode, ListNode> recursion = new BiFunction<ListNode, ListNode, ListNode>() {
            @Override
            public ListNode apply(ListNode previous, ListNode left) {
                // 无剩余节点 递归临界点
                if (left == null) {
                    return previous;
                }
                
                // 下一次递归的剩余链表
                ListNode t = left.next;
                // 新的反转链表
                left.next = previous;
                // 下一次递归的反转链表
                previous = left;

                return this.apply(previous, t);
            }
        };

        return recursion.apply(null, head);
    }

    /**
     * 迭代法
     * @param head {@link ListNode}
     * @return {@link ListNode}
     */
    public ListNode iteratorReverseList(ListNode head) {
        ListNode h = new ListNode(0), temp;
        while (head != null) {
            // 当前节点
            temp = head;
            // 迭代头结点
            head = head.next;
            // 将当前节点移动到反转链表头部
            temp.next = h.next;
            // 反转链表头指针指向新反转链表
            h.next = temp;
        }

        return h.next;
    }
    // #endregion snippet
}
