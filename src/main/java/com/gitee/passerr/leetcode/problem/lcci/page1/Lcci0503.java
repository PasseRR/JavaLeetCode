package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * <p>
 * 示例 2：
 * 输入: num = 7(01112)
 * 输出: 4
 * @author xiehai
 * @date 2020/06/23 09:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0503 {
    // #region snippet
    public int reverseBits(int num) {
        // 分别记录最大连续数量(包括从0变为1一次)、前一次连续1的数量、当前连续1的数量
        int max = 0, previous = 0, count = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                // 当前位为1
                count++;
            } else {
                // 记录当前最大值为两段连续的1数量加上变为0的数量
                max = Math.max(max, count + previous + 1);
                // 记录前一段连续数量
                previous = count;
                // 重置当前连续1的数量
                count = 0;
            }
            // 向右移位
            num >>= 1;
        }

        // 比较当前最大值和最后一次连续1的数量
        return Math.max(max, count + previous + 1);
    }
    // #endregion snippet
}
