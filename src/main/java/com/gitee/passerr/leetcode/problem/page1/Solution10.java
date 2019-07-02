package com.gitee.passerr.leetcode.problem.page1;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * @author xiehai
 * @date 2019/07/02 10:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        int pi = 0;
        if (sLength > 0 && pLength > 0) {
            char sc = s.charAt(0);
            char pc = p.charAt(pi);
            if (sc == pc || pc == '.') {
                // p是通配符匹配
                if (pLength > pi + 1 && p.charAt(pi + 1) == '*') {
                    // 去掉重复通配符
                    while (pi + 3 < pLength && p.charAt(pi + 3) == '*' && p.charAt(pi + 2) == pc) {
                        pi += 2;
                    }
                    // 出现通配符的三种处理方式
                    return
                        // 1.s串不变 p串匹配
                        this.isMatch(s, p.substring(pi + 2))
                            // 2.s串匹配 p串匹配
                            || this.isMatch(s.substring(1), p.substring(pi + 2))
                            // 1.s串匹配 p串不变
                            || this.isMatch(s.substring(1), p.substring(pi));
                }

                return this.isMatch(s.substring(1), p.substring(pi + 1));
            }

            // p串存在通配符 匹配通配符
            return (pi + 1 < pLength && p.charAt(pi + 1) == '*') && this.isMatch(s, p.substring(pi + 2));
        }

        // 未匹配完成
        if (sLength > 0) {
            return false;
        }

        // p串去掉多余通配符串
        while (pi < pLength) {
            if (pi + 1 < pLength && p.charAt(pi + 1) == '*') {
                pi += 2;
            } else {
                return false;
            }
        }

        return true;
    }
}
