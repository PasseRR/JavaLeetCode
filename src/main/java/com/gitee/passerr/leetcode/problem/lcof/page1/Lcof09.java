package com.gitee.passerr.leetcode.problem.lcof.page1;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * @author xiehai
 * @date 2020/07/04 14:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof09 {

}

class CQueue {
    /**
     * 读栈
     */
    int[] read;
    /**
     * 写栈
     */
    int[] write;
    /**
     * 读索引
     */
    int readIndex;
    /**
     * 写索引
     */
    int writeIndex;

    public CQueue() {
        // 由题意最多10000个元素
        this.read = new int[10001];
        this.write = new int[10001];
        this.readIndex = -1;
        this.writeIndex = -1;
    }

    public void appendTail(int value) {
        this.write[++this.writeIndex] = value;
    }

    public int deleteHead() {
        if (this.writeIndex == -1 && this.readIndex == -1) {
            return -1;
        }

        if (this.readIndex == -1) {
            // 此时 读栈已经是一个队列
            while (this.writeIndex > -1) {
                this.read[++this.readIndex] = this.write[this.writeIndex--];
            }
        }

        return this.read[this.readIndex--];
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
