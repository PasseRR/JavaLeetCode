package com.gitee.passerr.leetcode.problem.lcof.page1;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 限制：
 * 0 <= s 的长度 <= 50000
 * @author xiehai
 * @date 2020/07/14 13:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof50 {
    public char firstUniqChar(String s) {
        // 缓存字符数量
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            // 记录字符出现次数
            cache[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            // 找到第一个出现次数为1的字符
            if (cache[c - 'a'] == 1) {
                return c;
            }
        }

        // 空格字符
        return ' ';
    }
}
