package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @author xiehai
 * @date 2020/06/05 15:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
