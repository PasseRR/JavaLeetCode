package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
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
 * <p>
 * 提示：
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author xiehai
 * @date 2020/07/14 13:13
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof48 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), max = 0;
        Map<Character, Integer> visited = new HashMap<>(8);
        // 记录子字符串开始索引位置
        int start = 0;
        // 使用窗口滑动
        for (int i = 0; i < len; i++) {
            char at = s.charAt(i);
            // 若存在重复字符 且重复字符的索引位置在start之后
            // 则设置开始位置为当前字符位置之后一位
            if (visited.containsKey(at) && visited.get(at) >= start) {
                start = visited.get(at) + 1;
            }
            max = Integer.max(max, i - start + 1);
            visited.put(at, i);
        }

        return max;
    }
}
