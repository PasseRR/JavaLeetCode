package com.gitee.passerr.leetcode.problem.lcof.page1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 * @author xiehai
 * @date 2020/07/04 15:59
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof30 {
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
            this.stack.push(Integer.min(min, x));
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

    public int min() {
        return this.stack.peek();
    }
}
