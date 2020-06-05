package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>
 * 示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * 你能只调用一次检查子串的方法吗？
 * @author xiehai
 * @date 2020/06/05 16:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0109 {
    public boolean isFlipedString(String s1, String s2) {
        // 若是旋转字符串 s1+s1包含s2 同理 s2+s2包含s1 首尾相连
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
