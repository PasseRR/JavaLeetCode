package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * <p>
 * 示例2:
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 * @author xiehai
 * @date 2020/06/05 18:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0303 {
}

// #region snippet
class StackOfPlates {
    /**
     * 栈数据存储
     */
    private List<List<Integer>> data = new ArrayList<>();
    /**
     * 栈容量
     */
    private int capacity;

    public StackOfPlates(int cap) {
        this.capacity = cap;
    }

    public void push(int val) {
        // 考虑容量为0的case
        if (this.capacity == 0) {
            return;
        }

        int size = this.data.size();
        // 栈满 增加另一个栈
        if (size == 0 || this.data.get(size - 1).size() == this.capacity) {
            this.data.add(new ArrayList<>());
        }

        this.data.get(this.data.size() - 1).add(val);
    }

    public int pop() {
        // 弹出最后一个栈的元素
        return this.doPop(this.data.size() - 1);
    }

    private int doPop(int index) {
        int size = this.data.size();
        // 栈索引不存在或者栈为空
        if (index > size - 1 || index < 0) {
            return -1;
        }

        List<Integer> list = this.data.get(index);
        if (list.isEmpty()) {
            return -1;
        }
        int value = list.remove(list.size() - 1);

        // 当栈为空时 移除栈
        if (list.isEmpty()) {
            this.data.remove(list);
        }

        return value;
    }

    public int popAt(int index) {
        // 弹出指定索引栈的元素
        return this.doPop(index);
    }
}

// #endregion snippet
