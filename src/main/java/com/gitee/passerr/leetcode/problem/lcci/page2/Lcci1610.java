package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
 * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，
 * 那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * <p>
 * 示例：
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 * <p>
 * 提示：
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 * @author xiehai
 * @date 2020/08/21 10:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1610 {
    // #region snippet
    public int maxAliveYear(int[] birth, int[] death) {
        // 最多生存101年 死亡年份范围为1901-2001
        int[] dp = new int[102];
        // 无论哪年出生、死亡，客观上不会影响总人口数量
        for (int i = 0; i < birth.length; i++) {
            // 出生年份 之后人数一致
            dp[birth[i] - 1900]++;
            // 死亡年份第二年才会影响生存人数
            dp[death[i] - 1900 + 1]--;
        }

        int maxIndex = 0, max = dp[maxIndex], alive = max;
        for (int i = 1; i < dp.length; i++) {
            // 记录到第(1900+i)年总共生存人数
            alive += dp[i];
            if (alive > max) {
                max = alive;
                maxIndex = i;
            }
        }

        return maxIndex + 1900;
    }
    // #endregion snippet
}
