package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.Arrays;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * <p>
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * 限制：
 * 最多会对 addNum、findMedia进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode.cn/problems/find-median-from-data-stream/
 * @author xiehai
 * @date 2020/07/14 12:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof41 {
}

// #region snippet
class MedianFinder {
    int[] data;
    int size = 0;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.data = new int[50001];
    }

    public void addNum(int num) {
        this.data[this.size++] = num;
    }

    public double findMedian() {
        boolean isOdd = (this.size & 1) == 1;
        int mid = this.size >> 1;
        Arrays.sort(this.data, 0, this.size);
        return isOdd ? this.data[mid] : (this.data[mid] + this.data[mid - 1]) / 2.0D;
    }
}
// #endregion snippet
