package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，
 * 即滑动窗口里所有数字的平均值。
 * 
 *
 * 示例：
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 *
 * 提示：
 * 1 <= size <= 1000
 * -10<sup>5</sup> <= val <= 10<sup>5</sup>
 * 最多调用 next 方法 10<sup>4</sup> 次
 *
 * 注意：本题与主站 346题相同：https://leetcode-cn.com/problems/moving-average-from-data-stream/
 * @author xiehai
 * @date 2022/01/13 17:25
 */
public class Lcof041 {
}

class MovingAverage {
    /**
     * 链表尾节点
     */
    Node tail = new Node(0);
    /**
     * 链表头结点
     */
    Node head = tail;
    /**
     * 数字个数
     */
    int len = 0;
    /**
     * 当前链表总和
     */
    int sum = 0;
    /**
     * 窗口大小
     */
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        // 链表尾部添加节点
        this.sum += val;
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
        this.len++;

        // 节点数量大于窗口 窗口向左滑动
        if (this.len > this.size) {
            // 头节点滑动
            this.sum -= this.head.next.value;
            this.head = this.head.next;
        }

        // 平均值计算
        return 1.0D * sum / Integer.min(this.len, this.size);
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
