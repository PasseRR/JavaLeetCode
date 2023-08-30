package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * <p>
 * 示例2:
 * 输入：num = 1
 * 输出：[2, -1]
 * <p>
 * 提示:
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * @author xiehai
 * @date 2020/06/23 09:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0504 {
    // #region snippet
    public int[] findClosedNumbers(int num) {
        int i = 0, left = num, right = num;
        while (i < 31) {
            // 高位为0低位为1的位置
            if ((left & (1 << i + 1)) == 0 && (left & (1 << i)) > 0) {
                // 高位变1
                left |= 1 << i + 1;
                // 低位变0
                left &= ~(1 << i);

                // 将最右连续的1向右移至低位0处
                int bit = 0, j = 0;
                while (j < i && (left & (1 << j)) == 0) {
                    j++;
                    bit++;
                }

                int shift = 0;
                while (j < i && (left & (1 << j)) > 0) {
                    left &= ~(1 << j);
                    shift |= 1 << j;
                    j++;
                }

                left |= (shift >> bit);
                break;
            }
            i++;
        }


        i = 0;
        while (i < 31) {
            // 高位为1低位为0的位置
            if ((right & (1 << i + 1)) > 0 && (right & (1 << i)) == 0) {
                // 低位变1
                right |= 1 << i;
                // 高位变0
                right &= ~(1 << i + 1);

                // 将最右连续的1向左移至低位1处
                int bit = 0;
                while ((--i) >= 0 && (right & (1 << i)) == 0) {
                    bit++;
                }

                int shift = 0;
                while (i >= 0 && (right & (1 << i)) > 0) {
                    right &= ~(1 << i);
                    shift |= 1 << i;
                    i--;
                }

                right |= (shift << bit);
                break;
            }
            i++;
        }

        // 较大值可能会溢出 较小值可能不存在
        return new int[]{Integer.max(left, -1), right == num ? -1 : right};
    }
    // #endregion snippet
}
