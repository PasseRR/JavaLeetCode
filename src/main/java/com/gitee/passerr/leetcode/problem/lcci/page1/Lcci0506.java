package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * <p>
 * 示例2:
 * 输入：A = 1，B = 2
 * 输出：2
 * <p>
 * 提示:
 * A，B范围在[-2147483648, 2147483647]之间
 * @author xiehai
 * @date 2020/06/23 09:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0506 {
    // #region snippet
    public int convertInteger(int A, int B) {
        // A、B异或结果为1的位为不同部分
        int c = A ^ B, count = 0;

        while (c != 0) {
            // 每次去掉最低位的1
            c &= (c - 1);
            count++;
        }

        return count;
    }
    // #endregion snippet
}
