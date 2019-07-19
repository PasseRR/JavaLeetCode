package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @author xiehai
 * @date 2019/07/17 18:39
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        // 缓存t中出现的字符及次数
        Map<Character, Integer> cache = new HashMap<>();
        for (char ch : t.toCharArray()) {
            cache.merge(ch, 1, (o, n) -> n + o);
        }
        // 维护双指针
        int left = 0, right = 0;
        // 已遍历满足t的字符出现次数
        Map<Character, Integer> snapshot = new HashMap<>();
        // 字符类型数量
        int size = 0;
        String min = "";
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (cache.containsKey(ch)) {
                // 记录字符出现的次数
                snapshot.merge(ch, 1, (o, n) -> o + n);
                // 如果字符出现次数满足t
                if (snapshot.get(ch).equals(cache.get(ch))) {
                    size++;
                }
            }
            // 已经找到满足条件的子字符串
            // 收缩左边
            while (size == cache.size()) {
                char old = s.charAt(left);
                if (cache.containsKey(old)) {
                    snapshot.compute(old, (k, v) -> v - 1);
                    // 如果出现字符个数变少 说明移除此字符已经不满足条件
                    if (snapshot.get(old) < cache.get(old)) {
                        // 根据left和right窗口获得子串
                        if ("".equals(min) || min.length() > (right - left + 1)) {
                            min = s.substring(left, right + 1);
                        }
                        // 字符次数不满足条件
                        size--;
                    }
                }
                left++;
            }

            right++;
        }

        return min;
    }
}
