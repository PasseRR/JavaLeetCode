package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.function.BiFunction;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * <p>
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * <p>
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * <p>
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * @author xiehai
 * @date 2019/07/09 18:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution44 {
    // #region snippet
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        // 双指针
        int si = 0, pi = 0;
        // *所在位置 以及*对应s所在位置
        int starIndex = -1, matchIndex = -1;
        while (si < sl) {
            // 字符匹配 继续匹配下一个字符
            if (pi < pl && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < pl && p.charAt(pi) == '*') {
                // 从匹配空字符串继续匹配
                // 连续的*号继续相同处理
                // s被*匹配的位置 从当前位置开始
                matchIndex = si;
                // *的开始位置
                starIndex = pi;
                // 到下一个p待匹配字符
                pi++;
            } else if (starIndex > -1) {
                // 若有* 从*位置开始直到找到下一个能与s中某个字符匹配结束
                pi = starIndex + 1;
                si = ++matchIndex;
            } else {
                // 不能匹配或p无剩余待匹配字符 直接结束
                return false;
            }
        }

        // p还有剩余字符 若全部是* 则匹配 否则不能匹配
        if (pi < pl) {
            return p.substring(pi, pl).replace("*", "").isEmpty();
        }

        return true;
    }

    // 递归 tle了
    public boolean isMatchTle(String s, String p) {
        // p中用*代替多个连续的*
        String temp = p;
        while (temp.contains("**")) {
            temp = temp.replace("**", "*");
        }
        final String np = temp;
        int sl = s.length(), pl = np.length();

        BiFunction<Integer, Integer, Boolean> match = new BiFunction<Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer si, Integer pi) {
                // s已经匹配完成 p也匹配完或者剩余字符为* 则匹配成功
                if (si == sl) {
                    return pi == pl || np.charAt(pi) == '*' && this.apply(si, pi + 1);
                }

                // 若p已经到最后 匹配失败
                if (pi == pl) {
                    return false;
                }

                char sc = s.charAt(si);
                char pc = np.charAt(pi);

                // 字符相同或p所在字符为? 匹配下一字符
                if (sc == pc || pc == '?') {
                    return this.apply(si + 1, pi + 1);
                }

                // *可采取匹配空或匹配当前或者继续匹配
                return pc == '*' && (this.apply(si + 1, pi + 1) || this.apply(si + 1, pi) || this.apply(si, pi + 1));
            }
        };

        return match.apply(0, 0);
    }
    // #endregion snippet
}
