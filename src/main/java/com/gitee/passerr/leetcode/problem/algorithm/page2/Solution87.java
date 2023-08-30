package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * <p>
 * 示例 1:
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * @author xiehai
 * @date 2019/07/22 16:37
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution87 {
    // #region snippet
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int length;
        if ((length = s1.length()) != s2.length()) {
            return false;
        }

        // 字符数量是否一致
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < length; i++) {
            count.merge(s1.charAt(i), 1, (o, n) -> o + n);
            count.merge(s2.charAt(i), -1, (o, n) -> o + n);
        }
        if (count.keySet().stream().anyMatch(it -> count.get(it) != 0)) {
            return false;
        }

        // 找字符串互为扰乱的分割点
        for (int i = 1; i < length; i++) {
            // 在两个字符串中取相同长度i的子字符串
            // 肯定会存在一个i使s1前i个子字符串与s2前i个或后i个子字符串互为扰乱
            // 且 s1和s2的剩余部分也互为扰乱
            if ((this.isScramble(s1.substring(0, i), s2.substring(0, i))
                && this.isScramble(s1.substring(i), s2.substring(i)))
                ||
                (this.isScramble(s1.substring(0, i), s2.substring(length - i))
                    && this.isScramble(s1.substring(i), s2.substring(0, length - i)))) {
                return true;
            }
        }

        return false;
    }
    // #endregion snippet
}
