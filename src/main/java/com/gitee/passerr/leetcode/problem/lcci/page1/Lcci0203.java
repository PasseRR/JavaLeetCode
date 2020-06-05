package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * @author xiehai
 * @date 2020/06/05 16:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0203 {
    public void deleteNode(ListNode node) {
        // 将给定节点值改为下一个节点值
        node.val = node.next.val;
        // 节点移动
        node.next = node.next.next;
    }
}
