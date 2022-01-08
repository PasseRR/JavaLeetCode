package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.Node;

import java.util.function.BiFunction;

/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * 输入的多级列表如下图所示：
 * 扁平化后的链表如下图：
 * <p>
 * 示例 2：
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * 输入的多级列表如下图所示：
 * 1---2---NULL
 * |
 * 3---NULL
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 如何表示测试用例中的多级链表？
 * 以 示例 1 为例：
 * | 1---2---3---4---5---6--NULL
 * |         |
 * |         7---8---9---10--NULL
 * |             |
 * |             11--12--NULL
 * 序列化其中的每一级之后：
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * 提示：
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 * <p>
 * 注意：本题与主站 430题相同：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @author xiehai
 * @date 2022/01/07 13:54
 */
public class Lcof028 {
    public Node flatten(Node head) {
        // 空处理
        if (head == null) {
            return null;
        }

        Node r = new Node();
        // 递归展开链表
        BiFunction<Node, Node, Node> recursion = new BiFunction<Node, Node, Node>() {
            @Override
            public Node apply(Node h, Node t) {
                if (t == null) {
                    return h;
                }

                // 将当前节点添加到尾部节点
                Node node = new Node();
                node.val = t.val;
                // 双向指针
                h.next = node;
                node.prev = h;
                // 将尾部指向当前节点
                h = h.next;

                // 若存在子链表 优先遍历
                if (t.child != null) {
                    h = this.apply(h, t.child);
                }

                // 继续遍历后继链表
                return this.apply(h, t.next);
            }
        };

        // r表示已经展开链表的尾部节点 第二个参数表示带展开链表的头部结点 
        recursion.apply(r, head);
        // 删除头部第一个节点的prev指针
        r.next.prev = null;

        return r.next;
    }
}