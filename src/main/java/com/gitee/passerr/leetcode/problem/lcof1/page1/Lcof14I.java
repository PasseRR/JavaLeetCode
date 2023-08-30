package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 提示：
 * 2 <= n <= 58
 * @author xiehai
 * @date 2020/07/04 14:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof14I {
    // #region snippet
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        // 1、2、3长度的绳子可以拼接成任意长度的绳子
        int product = 1;
        while (n > 0) {
            // 1、2可以组合成3 1*2 < 3 3为最优解
            // 4可以拆分为2*2和1*3 2*2为最优解
            // 2可以拆分为1*1和2 2为最优解
            if (n == 4 || n == 2) {
                product *= n;
                break;
            }
            product *= 3;
            n -= 3;
        }

        return product;
    }
    // #endregion snippet
}
