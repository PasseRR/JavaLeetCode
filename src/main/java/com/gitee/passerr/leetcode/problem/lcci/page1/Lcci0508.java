package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。
 * 屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。
 * 请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
 * 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。
 * 返回绘制过后的数组。
 * <p>
 * 示例1:
 * 输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 * 输出：[3]
 * 说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
 * <p>
 * 示例2:
 * 输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 * 输出：[-1, -1, -1]
 * @author xiehai
 * @date 2020/06/23 09:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0508 {
    // #region snippet
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] result = new int[length];
        // 数字像素长度 屏幕宽度几个数字
        int len = 32, width = w / len;

        // 保证x1小于x2
        if (x1 > x2) {
            x1 ^= x2;
            x2 ^= x1;
            x1 ^= x2;
        }

        // 根据直线起止位置找到横跨的数字位置
        for (int j = x1 / len; j < (x2 / len + (x2 % len == 0 ? 0 : 1)); j++) {
            // 数字开始像素索引
            int begin = j * len;
            // 数字结束像素索引
            int end = (j + 1) * len - 1;
            // 若包含一个数字的开始符号位像素 则是负数 否则为正数
            if (x1 <= begin) {
                // 区分是正数还是负数
                result[y * width + j] = -1;
                // 由低位到高位去0的位数
                int bit = end - Math.min(x2, end);
                // 去掉低位的0
                for (int i = 0; i < bit; i++) {
                    result[y * width + j] &= (result[y * width + j] - 1);
                }
            } else {
                // 需要左移动位数 确定最低位1
                // 若终点像素大于当前数字最大像素则从1开始 否则左移
                result[y * width + j] = 1 << (x2 >= end ? 0 : end - x2);
                int bit = Math.min(x2, end) - Math.max(x1, begin);
                for (int i = 0; i < bit; i++) {
                    // 高位加1
                    result[y * width + j] |= (result[y * width + j] << 1);
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
