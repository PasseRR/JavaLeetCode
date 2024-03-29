package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'。
 * <p>
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,231−1]。本题中，如果除法结果溢出，则返回 2<sup>31</sup>− 1
 * <p>
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * <p>
 * 示例 2：
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 示例 3：
 * 输入：a = 0, b = 1
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：a = 1, b = 1
 * 输出：1
 * <p>
 * 提示:
 * -2<sup>31</sup><= a, b <= 2<sup>31</sup>- 1
 * b != 0
 * @author xiehai
 * @date 2021/12/10 13:48
 */
public class Lcof001 {
    // #region snippet
    public int divide(int a, int b) {
        // 结果是否是正数
        boolean isPositive = a >= 0 == b >= 0;
        // 将数字转为负数 保证不溢出 若取数字绝对值可能会正数溢出
        if (a > 0) {
            a = ~a + 1;
        }
        if (b > 0) {
            b = ~b + 1;
        }
        int result = 0;

        // 因为是负数 所以商大于0时 a <= b
        while (a <= b) {
            // t为b左移的位数 c为移动结果
            int t = 0, c = b;

            // 如 18 / 2 
            // 18 - 2 1
            // 16 - 4 2 
            // 12 - 6 3
            // 当前轮结果为6
            // 余6
            // 6 - 2 1
            // 4 - 4 2
            // 当前轮结果为9
            while (a <= c) {
                result += 1 << t;
                a -= c;
                t++;
                c <<= 1;
                // 左移溢出
                if (c >= 0) {
                    break;
                }
            }
        }

        // 若结果是正数
        if (isPositive) {
            // 预期结果是正数 实际计算结果为负数时 说明正数溢出返回int最大值
            return result < 0 ? Integer.MAX_VALUE : result;
        }

        return ~result + 1;
    }
    // #endregion snippet
}
