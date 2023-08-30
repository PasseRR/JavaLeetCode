package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * <p>
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * <p>
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * <p>
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * <p>
 * 提示：
 * 1 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * @author xiehai
 * @date 2020/09/01 17:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1618 {
    // #region snippet
    public boolean patternMatching(String pattern, String value) {
        int pl = pattern.length(), vl = value.length();
        String[] dict = new String[2];
        char first = pattern.charAt(0);
        // 第一个出现的匹配字符索引
        int firstIndex = first - 'a';
        for (int i = 0; i <= vl; i++) {
            dict[firstIndex] = value.substring(0, i);
            int index = 0, offset = 0;
            while (index < pl && pattern.charAt(index) == first && value.substring(offset, vl).startsWith(dict[firstIndex])) {
                index++;
                offset += dict[firstIndex].length();
                if (offset > vl) {
                    break;
                }
            }

            // 超过预期字符串长度
            if (offset > vl) {
                continue;
            }

            // 如果只存在一种字符
            if (index == pl) {

                if (offset < vl) {
                    continue;
                }

                return true;
            }

            for (int j = offset; j <= vl; j++) {
                int t = index, to = offset;
                String s;
                // 第二个出现的匹配字符
                dict[firstIndex ^ 1] = value.substring(to, j);
                while (t < pl && value.substring(to, vl).startsWith(s = dict[pattern.charAt(t) - 'a'])) {
                    t++;
                    to += s.length();
                }

                if (t == pl && to == vl) {
                    return !dict[firstIndex].equals(dict[firstIndex ^ 1]);
                }
            }
        }

        return false;
    }
    // #endregion snippet
}
