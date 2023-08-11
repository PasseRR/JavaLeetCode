package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 给定两个单链表的头节点headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例2：
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 10<sup>4</sup>
 * 1 <= Node.val <= 10<sup>5</sup>
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * 进阶：能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * <p>
 * 注意：本题与主站 160题相同：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author xiehai
 * @date 2022/01/06 13:46
 */
public class Lcof023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode cursor1 = headA, cursor2 = headB;

        // 获得两个链表的长度
        while (cursor1 != null) {
            cursor1 = cursor1.next;
            len1++;
        }
        while (cursor2 != null) {
            cursor2 = cursor2.next;
            len2++;
        }

        // 重置指针
        cursor1 = headA;
        cursor2 = headB;

        // 若两个链表有交点 则尾部是一样的
        // 从两个链表节点数量一致是开始 依次比较链表节点
        while (len1 > len2) {
            cursor1 = cursor1.next;
            len1--;
        }
        while (len2 > len1) {
            cursor2 = cursor2.next;
            len2--;
        }

        // 相同链表长度开始遍历节点比较
        while (len1 > 0) {
            if (cursor1 == cursor2) {
                return cursor1;
            }

            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
            len1--;
        }

        return null;
    }
}
