package com.gitee.passerr.leetcode.problem.lcof1.page2;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * @author xiehai
 * @date 2020/07/22 09:05
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof59II {
}

// #region snippet
class MaxQueue {
    // 队列数据
    int[] data;
    // 最大值位置
    int max;
    // 队列头结点位置
    int head;
    // 队列尾节点位置
    int tail;
    // 队列大小
    int size;

    public MaxQueue() {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.max = -1;
        this.data = new int[10001];
    }

    public int max_value() {
        return this.size == 0 ? -1 : this.data[this.max];
    }

    public void push_back(int value) {
        // 当前值大于最大值
        if (this.size == 0 || value > this.data[this.max]) {
            this.max = this.tail;
        }
        this.size++;
        this.data[this.tail++] = value;
    }

    public int pop_front() {
        if (this.size == 0) {
            return -1;
        }

        this.size--;

        // 窗口滑动 若当前头结点为最大值 查找新的最大值
        if (this.max == this.head) {
            int value = Integer.MIN_VALUE;
            for (int i = 0; i < this.size; i++) {
                int index = this.head + i + 1;
                if (this.data[index] > value) {
                    value = this.data[index];
                    this.max = index;
                }
            }
        }

        return this.data[head++];
    }
}
// #endregion snippet
