package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * 示例：
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * @author xiehai
 * @date 2020/06/05 18:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0304 {
}

// #region snippet
class MyQueue {
    /**
     * 用于存储push元素
     */
    Stack<Integer> write = new Stack<>();
    /**
     * 用于读取队列元素
     */
    Stack<Integer> read = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.write.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        this.compact();
        return this.read.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        this.compact();
        return this.read.peek();
    }

    /**
     * 将写栈转压入读栈
     */
    private void compact() {
        // 读栈为空时 倒叙将写栈压入读栈
        if (this.read.isEmpty()) {
            // 此时 读栈已经是一个队列
            while (!this.write.isEmpty()) {
                this.read.push(this.write.pop());
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        // 两个栈均为空 表示队列为空
        return this.write.isEmpty() && this.read.isEmpty();
    }
}
// #endregion snippet
