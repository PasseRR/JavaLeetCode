package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长连续子字符串的长度。
 * <p>
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 * <p>
 * 注意：本题与主站 3题相同：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author xiehai
 * @date 2021/12/17 10:29
 */
public class Lcof016 {
    // #region snippet
    public int lengthOfLongestSubstring(String s) {
        int result = 0, len = s.length();
        // 按题意 ASCII码表
        int[] dict = new int[128];
        int left = 0, right = 0;
        
        while (right < len) {
            dict[s.charAt(right)]++;

            // 当最右边的字符出现了多次时 滑动窗口直到最右字符个数为1
            while (dict[s.charAt(right)] > 1) {
                dict[s.charAt(left--)]--;
            }

            result = Integer.max(result, right - left + 1);
            right++;
        }

        return result;
    }
    // #endregion snippet
}
