package com.gitee.passerr.leetcode.problem.algorithm.page4;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @author xiehai
 * @date 2019/07/26 14:53
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution155 {
}

class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        // 栈顶为最小元素
        // 次栈顶为本身栈顶元素
        if (this.stack.isEmpty()) {
            this.stack.push(x);
            this.stack.push(x);
        } else {
            int min = this.stack.peek();
            this.stack.push(x);
            this.stack.push(min > x ? x : min);
        }
    }

    public void pop() {
        this.stack.pop();
        this.stack.pop();
    }

    public int top() {
        // 栈顶元素为次栈顶
        return stack.get(this.stack.size() - 2);
    }

    public int getMin() {
        return this.stack.peek();
    }
}
