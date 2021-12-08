package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @author xiehai
 * @date 2020/07/04 14:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof05 {
    public String replaceSpace(String s) {
        // 保证字符长度
        char[] chars = new char[s.length() * 3];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                chars[count++] = '%';
                chars[count++] = '2';
                chars[count++] = '0';
            } else {
                chars[count++] = c;
            }
        }

        // 根据字符长度生成字符串
        return new String(chars, 0, count);
    }
}
