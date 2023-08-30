package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * <p>
 * 示例2:
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * <p>
 * 说明:
 * 栈中的元素数目在[0, 5000]范围内。
 * @author xiehai
 * @date 2020/06/05 19:12
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0305 {
}

// #region snippet
class SortedStack {
    /**
     * 数据降序栈
     */
    private Stack<Integer> data = new Stack<>();
    /**
     * 辅助栈
     */
    private Stack<Integer> assist = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        if (this.data.isEmpty() || this.data.peek() >= val) {
            this.data.push(val);
        } else {
            // 找到数据栈中大于val的位置
            // 比较栈顶元素是否小于val
            while (!this.isEmpty() && this.data.peek() < val) {
                this.assist.push(this.data.pop());
            }
            this.data.push(val);

            // 将辅助栈中的数据放入数据栈
            while (!this.assist.isEmpty()) {
                this.data.push(this.assist.pop());
            }
        }
    }

    public void pop() {
        if (!this.isEmpty()) {
            this.data.pop();
        }
    }

    public int peek() {
        return this.isEmpty() ? -1 : this.data.peek();
    }


    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}

// #endregion snippet
