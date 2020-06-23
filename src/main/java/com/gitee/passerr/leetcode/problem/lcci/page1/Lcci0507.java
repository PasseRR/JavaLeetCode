package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * <p>
 * 示例2:
 * 输入：num = 3
 * 输出：3
 * <p>
 * 提示:
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 * @author xiehai
 * @date 2020/06/23 09:49
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0507 {
    public int exchangeBits(int num) {
        int result = 0;
        // 交换非符号位部分
        for (int i = 0; i < 32; i += 2) {
            // 如果奇数位存在 则将其变为偶数位
            if ((num & (1 << i)) > 0) {
                result |= 1 << (i + 1);
            }

            // 如果偶数位存在 则将其变为奇数位
            if ((num & (1 << (i + 1))) > 0) {
                result |= 1 << i;
            }
        }

        // 存在符号位 将符号位调换至高位
        if (num < 0) {
            result |= 1 << 30;
        }

        return result;
    }
}
