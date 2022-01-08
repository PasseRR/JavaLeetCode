package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.Node;

/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 * 示例 1：
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 * <p>
 * 示例 2：
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 * <p>
 * 提示：
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 * <p>
 * 注意：本题与主站 708题相同：https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
 * @author xiehai
 * @date 2022/01/07 15:31
 */
public class Lcof029 {
    public Node insert(Node head, int insertVal) {
        Node append = new Node(insertVal);
        // 空的话初始节点自循环
        if (head == null) {
            append.next = append;
            return append;
        }

        Node slow = head, fast = head.next, max = head;

        // 保证只遍历一圈
        // 使用do while的原因是跳过第一次比较
        do {
            if (slow.val <= insertVal && fast.val >= insertVal) {
                slow.next = append;
                append.next = fast;
                return head;
            }
            // 即使存在相同值的节点也更新节点位置
            // 如 [1, 3, 3] -> 4 => [1, 3, 4, 3]而[1, 3, 3, 4]才是正解
            if (slow.val >= max.val) {
                max = slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        while (slow != head);

        // 若找了一圈没有找到满足条件的数字 即插入的是一个极小或者极大值
        // 无论是最大还是最小 都将这个值放在最大值之后
        Node t = max.next;
        max.next = append;
        append.next = t;

        return head;
    }
}
