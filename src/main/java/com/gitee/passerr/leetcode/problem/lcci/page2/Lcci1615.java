package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，
 * 则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 示例：
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * <p>
 * 提示：
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 * @author xiehai
 * @date 2020/08/27 11:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1615 {
    // #region snippet
    public int[] masterMind(String solution, String guess) {
        // 按照字符计数、猜中及伪猜中
        int[] counter = new int[26], result = new int[2];
        // 计数猜测颜色
        for (int i = 0; i < 4; i++) {
            char g = guess.charAt(i);
            // 计数颜色出现次数
            counter[g - 'A']++;
            if (g == solution.charAt(i)) {
                // 猜中计数
                result[0]++;
                // 颜色计数减1
                counter[g - 'A']--;
            }
        }

        // 根据猜测计数判断伪猜中
        for (int i = 0; i < 4; i++) {
            char s = solution.charAt(i);
            if (guess.charAt(i) != s && counter[s - 'A'] > 0) {
                // 伪猜中计数
                result[1]++;
                // 颜色计数减1
                counter[s - 'A']--;
            }
        }

        return result;
    }
    // #endregion snippet
}
