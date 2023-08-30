package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * @author xiehai
 * @date 2022/01/13 17:51
 */
public class Lcof042 {
}

// #region snippet
class RecentCounter {
    /**
     * 链表尾节点
     */
    Node tail = new Node(0);
    /**
     * 链表头结点
     */
    Node head = tail;
    /**
     * ping个数
     */
    int size = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        int open = t - 3000;
        // 当前请求时间添加到链表尾部
        this.tail.next = new Node(t);
        this.tail = this.tail.next;
        this.size ++;
        
        // 若当前链表头不在3000毫秒之内 则移动链表头
        while (this.head.next != null && this.head.next.value < open) {
            this.head = this.head.next;
            this.size --;
        }
        
        return this.size;
    }

    /**
     * 自定义链表
     */
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
// #endregion snippet
