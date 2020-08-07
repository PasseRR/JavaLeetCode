package com.gitee.passerr.leetcode.problem.lcci.page2;


/**
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * <p>
 * 示例 2:
 * 输入: s = "0&0&0&1^1|0", result = 1
 * 输出: 10
 * <p>
 * 提示：
 * 运算符的数量不超过 19 个
 * @author xiehai
 * @date 2020/08/04 16:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0814 {
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        // 符号位个数
        for (int len = 1; len <= n; len += 2) {
            // 数字位
            for (int i = 0; i + len - 1 < n; i += 2) {
                // 截断点
                int cut = i + len - 1;
                // 赋初始值，即只有一个数时
                if (len == 1) {
                    dp[i][cut][s.charAt(i) - '0'] = 1;
                }
                // 状态转移
                // 计算截断点之前的值
                for (int j = i + 1; j < cut; j += 2) {
                    char op = s.charAt(j);
                    switch (op) {
                        case '&': {
                            // 0&1 1&0 0&0
                            dp[i][cut][0] += dp[i][j - 1][0] * (dp[j + 1][cut][0] + dp[j + 1][cut][1])
                                + dp[i][j - 1][1] * dp[j + 1][cut][0];
                            // 1&1
                            dp[i][cut][1] += dp[i][j - 1][1] * dp[j + 1][cut][1];
                            break;
                        }
                        case '|': {
                            // 0|1 1|0 1|1
                            dp[i][cut][1] += dp[i][j - 1][1] * (dp[j + 1][cut][0] + dp[j + 1][cut][1])
                                + dp[i][j - 1][0] * dp[j + 1][cut][1];
                            // 0|0
                            dp[i][cut][0] += dp[i][j - 1][0] * dp[j + 1][cut][0];
                            break;
                        }
                        case '^': {
                            // 0^0 1^1
                            dp[i][cut][0] += dp[i][j - 1][0] * dp[j + 1][cut][0]
                                + dp[i][j - 1][1] * dp[j + 1][cut][1];
                            // 0^1 1^0
                            dp[i][cut][1] += dp[i][j - 1][0] * dp[j + 1][cut][1]
                                + dp[i][j - 1][1] * dp[j + 1][cut][0];
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        }

        return dp[0][n - 1][result];
    }
}
