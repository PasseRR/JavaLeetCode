package com.gitee.passerr.leetcode.problem.lcof.page1;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
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
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * @author xiehai
 * @date 2020/07/04 15:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof19 {
    private static final char POINT = '.';
    private static final char ASTER = '*';

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        // 匹配完成
        if (sLen == 0 && pLen == 0) {
            return true;
        }

        if (sLen > 0 && pLen > 0) {
            char cs = s.charAt(0);
            char cp = p.charAt(0);

            // 占位匹配考虑存在.*组合
            if (cp == POINT || cs == cp) {
                // 没有通配符匹配
                if (pLen < 2 || p.charAt(1) != ASTER) {
                    return this.isMatch(s.substring(1), p.substring(1));
                }

                // 考虑通配符匹配是否重复 必须通配符一致
                if (pLen >= 4 && p.charAt(2) == cp && p.charAt(3) == ASTER) {
                    return this.isMatch(s, p.substring(2));
                }

                return
                    // 匹配s字符 p通配符不去除
                    this.isMatch(s.substring(1), p)
                        // 不匹配s字符 p通配符去除
                        || this.isMatch(s, p.substring(2))
                        // 匹配s字符 p通配符去除
                        || this.isMatch(s.substring(1), p.substring(2));
            }

            // 若不相同 判断存在泛型匹配跳过后继续匹配
        }

        // p串非空 s串已经匹配完成 需要校验剩下的p串中是否都满足泛型匹配
        if (pLen > 0) {
            return pLen >= 2 && p.charAt(1) == ASTER && this.isMatch(s, p.substring(2));
        }


        // p串为空 s串未匹配完成
        return false;
    }
}
