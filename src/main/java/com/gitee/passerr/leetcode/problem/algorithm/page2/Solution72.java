package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @author xiehai
 * @date 2019/07/16 17:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution72 {
    // #region snippet
    /**
     * 莱文斯坦距离有几个简单的上下界，包括：
     * 1.至少总是两个字符串大小的差值；
     * 2.至多是较长字符串的长度；
     * 3.当且仅当两个字符串相等时值为0；
     * 4.如果两个字符串大小相等，汉明距离是其上界；
     * 5.两个字符串的莱文斯坦距离不大于分别与第三个字符串的莱文斯坦距离之和（三角不等式）。
     * <p>
     * 注:
     * Damerau–莱文斯坦距离（Damerau–Levenshtein distance）允许插入、删除、替换和交换两个相邻字符；
     * 最长公共子序列（ longest common subsequence）只允许插入和删除操作；
     * 汉明距离（Hamming distance）只允许替换操作，因此只适用于两个相等长度的字符串。
     * @param word1 单词1
     * @param word2 单词2
     * @return 最短距离
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // word1到空字符串word2 需要删除字符数量
        // 若都为空字符串 不需要任何操作
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        // 空字符串word1到word2 需要插入的字符数量
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                // 两个字符串对应位置字符一样 不做任何操作
                // 等同于上一字符位置的操作数
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 不相同可做操作替换、删除、插入
                    // 取最小值
                    dp[i + 1][j + 1] = Math.min(
                        // 替换
                        dp[i][j] + 1,
                        Math.min(
                            // 删除
                            dp[i][j + 1] + 1,
                            // 插入
                            dp[i + 1][j] + 1
                        )
                    );
                }
            }
        }

        return dp[l1][l2];
    }
    // #endregion snippet
}
