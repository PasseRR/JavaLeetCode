package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author xiehai
 * @date 2019/07/01 10:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // 缓存子串
        StringBuilder sb = new StringBuilder();

        for (int i = 0, length = s.length(); i < length; i++) {
            for (int j = i; j < length; j++) {
                String character = s.substring(j, j + 1);
                // 存在重复字符
                if (sb.indexOf(character) > -1) {
                    // 更新最大子串
                    if (sb.length() > result) {
                        result = sb.length();
                    }

                    // 清空当前子串
                    sb.delete(0, sb.length());
                    // 找到一个子串就结束遍历
                    break;
                }

                // 追加子串
                sb.append(character);
            }
        }

        // 遍历到最后子串都不存在重复字符的清空
        if (sb.length() > 0 && sb.length() > result) {
            result = sb.length();
        }

        return result;
    }
}
