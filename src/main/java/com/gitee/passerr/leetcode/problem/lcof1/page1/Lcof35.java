package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * @author xiehai
 * @date 2020/07/04 16:27
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof35 {
    public Node copyRandomList(Node head) {
        Node cursor = head;
        Map<Node, Node> nodes = new HashMap<>(1024);
        // 数值复制
        while (cursor != null) {
            nodes.put(cursor, new Node(cursor.val));
            cursor = cursor.next;
        }

        // 指针复制
        nodes.forEach((k, v) -> {
            v.next = nodes.get(k.next);
            v.random = nodes.get(k.random);
        });

        // 新的头结点
        return nodes.get(head);
    }
}
