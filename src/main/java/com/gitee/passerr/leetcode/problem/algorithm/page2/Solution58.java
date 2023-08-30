package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * @author xiehai
 * @date 2019/07/15 12:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution58 {
    // #region snippet
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isEmpty()) {
                return strings[i].length();
            }
        }

        return 0;
    }
    // #endregion snippet
}
