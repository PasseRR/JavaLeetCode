package com.gitee.passerr.leetcode.problem.lcci.page3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * @author xiehai
 * @date 2021/06/11 11:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1720 {

}

// #region snippet
class MedianFinder {
    Queue<Integer> min, max;

    public MedianFinder() {
        // 使用优先队列维护两个堆顶元素
        // 若为奇数时 则中位数为min堆顶
        // 否则 中位数为两个队列堆顶的平均值
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        this.min.offer(num);
        this.max.offer(this.min.poll());

        if (this.min.size() < this.max.size()) {
            this.min.offer(this.max.poll());
        }
    }

    public double findMedian() {
        return this.min.size() > this.max.size() ? this.min.peek() : (this.min.peek() + this.max.peek()) / 2.0D;
    }
}

// #endregion snippet
