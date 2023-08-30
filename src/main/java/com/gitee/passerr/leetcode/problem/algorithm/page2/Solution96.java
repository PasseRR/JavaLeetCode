package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @author xiehai
 * @date 2019/07/24 17:02
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution96 {
    // #region snippet
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // f(4)有几种情况，其实就4种，分别是以1为根，以2为根，以3为根，和以4为根。
        // 我们分别讨论4种根情况个数：
        // 如果以1为根，那么剩余的数只能在1的右子树，且剩余数也是按顺序234，相当于f(3)的个数。故1为根有f(0) * f(3) = 5;
        // 同理，以2为根，左子树只可能1，右子树是34，共有f(1)*f(2)=2；
        // 以3为根，f(2)*f(1)=2，
        // 以4为根，f(3) * f(0) = 5; 总结算法如下
        // f(n) = f(0)*f(n-1) + f(1)*f(n-2)+...+f(n-1)*f(0)
        // 可以看到公式左右两边是对称的 通过奇偶性判断对称点
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
    // #endregion snippet
}
