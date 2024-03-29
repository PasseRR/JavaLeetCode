package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
 * 请实现数据结构和算法来支持这些操作，也就是说： 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例:
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * <p>
 * 提示：
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 * @author xiehai
 * @date 2020/08/10 14:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1010 {
}

// #region snippet
class StreamRank {
    int[] data;
    int max;

    public StreamRank() {
        // 最大数字为50000
        this.data = new int[50001];
        // 最大值
        this.max = 0;
    }

    public void track(int x) {
        // 后续数字追加1
        for (int i = x; i <= this.max; i++) {
            this.data[i]++;
        }

        // 若为新的最大值
        if (this.max < x) {
            // 当前最大值之后赋值为当前最大值的佚
            Arrays.fill(this.data, this.max + 1, x + 1, this.data[this.max]);
            // 新的最大值佚加1
            this.data[x]++;
            // 更新最大值
            this.max = x;
        }
    }

    public int getRankOfNumber(int x) {
        // x小于最大值 返回x的佚 否则返回最大值的佚
        return this.data[Integer.min(x, this.max)];
    }
}
// #endregion snippet
