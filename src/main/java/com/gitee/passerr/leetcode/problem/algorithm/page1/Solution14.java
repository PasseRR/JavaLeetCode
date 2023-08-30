package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * @author xiehai
 * @date 2019/07/02 15:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution14 {
    // #region snippet
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        // 空数组 空前缀
        if (length == 0) {
            return "";
        }

        // 拟取第一个单词为公共前缀
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            // 每个单词是否以当前前缀开头 若不是 前缀尾部去掉一位
            for (int j = result.length(); !strs[i].startsWith(result); j--, result = result.substring(0, j));

            // 未找到公共前缀
            if (result.length() == 0) {
                return "";
            }
        }

        return result;
    }
    // #endregion snippet
}
