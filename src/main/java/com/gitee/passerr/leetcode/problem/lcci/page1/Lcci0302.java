package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @author xiehai
 * @date 2020/06/05 17:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0302 {
}

class MinStack {
    int[] data = new int[65536];
    int[] dataMin = new int[65536];
    int top = -1;
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (x < this.min) {
            this.min = x;
        }
        // 数据栈
        this.data[++this.top] = x;
        // 数据栈最小值
        this.dataMin[this.top] = this.min;
    }

    public void pop() {
        // 出栈索引递减
        this.top--;
        // 更新全局最小值
        this.min = this.top < 0 ? Integer.MAX_VALUE : this.getMin();
    }

    public int top() {
        // 数据栈顶部元素
        return this.data[this.top];
    }

    public int getMin() {
        // 最小栈顶部元素
        return this.dataMin[this.top];
    }
}

