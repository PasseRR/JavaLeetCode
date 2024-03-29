package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 * stackNum表示栈下标，value表示压入的值。构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * <p>
 * 示例2:
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * @author xiehai
 * @date 2020/06/05 17:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0301 {
}

// #region snippet
class TripleInOne {
    /**
     * 数组存储栈
     * 0 3 6..表示第一个栈
     * 1 4 7..表示第二个栈
     * 2 5 8..表示第三个栈
     */
    private int[] data;
    private int top1 = -3;
    private int top2 = -2;
    private int top3 = -1;

    public TripleInOne(int stackSize) {
        this.data = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        int next = this.getTop(stackNum) + 3;
        if (next < this.data.length) {
            data[next] = value;
            this.addTop(stackNum);
        }
    }

    public int pop(int stackNum) {
        int t = this.getTop(stackNum);
        if (t < 0) {
            return -1;
        }

        this.minusTop(stackNum);

        return data[t];
    }

    public int peek(int stackNum) {
        int t = this.getTop(stackNum);
        return t < 0 ? -1 : this.data[t];
    }

    public boolean isEmpty(int stackNum) {
        return this.getTop(stackNum) < 0;
    }

    private int getTop(int stackNum) {
        switch (stackNum) {
            case 0:
                return this.top1;
            case 1:
                return this.top2;
            default:
                return this.top3;
        }
    }

    private void addTop(int stackNum) {
        switch (stackNum) {
            case 0:
                this.top1 += 3;
                break;
            case 1:
                this.top2 += 3;
                break;
            default:
                this.top3 += 3;
                break;
        }
    }

    private void minusTop(int stackNum) {
        switch (stackNum) {
            case 0:
                this.top1 -= 3;
                break;
            case 1:
                this.top2 -= 3;
                break;
            default:
                this.top3 -= 3;
                break;
        }
    }
}
// #endregion snippet
