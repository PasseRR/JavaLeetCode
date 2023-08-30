package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * <p>
 * 示例1:
 * 输入：N = 10000000000, M = 10011, i = 2, j = 6
 * 输出：N = 10001001100
 * <p>
 * 示例2:
 * 输入： N = 0, M = 11111, i = 0, j = 4
 * 输出：N = 11111
 * @author xiehai
 * @date 2020/06/23 09:28
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0501 {
    // #region snippet
    public int insertBits(int N, int M, int i, int j) {
        // 将N从i位到j位置0
        for (int b = i; b <= j; b++) {
            if ((N & (1 << b)) > 0) {
                N &= ~(1 << b);
            }
        }

        // 置0后加上M向左移动i位
        return N | (M << i);
    }
    // #endregion snippet
}
