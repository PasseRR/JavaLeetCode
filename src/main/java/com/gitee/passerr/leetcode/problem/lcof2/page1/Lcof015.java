package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串s和p，找到s中所有 p 的变位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * 示例1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 * <p>
 * 提示:
 * 1 <= s.length, p.length <= 3 * 10<sup>4</sup>
 * s和 p 仅包含小写字母
 * <p>
 * 注意：本题与主站 438题相同：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author xiehai
 * @date 2021/12/17 10:14
 */
public class Lcof015 {
    public List<Integer> findAnagrams(String s, String p) {
        // 跟上一题一样 多记录个索引
        List<Integer> result = new ArrayList<>();
        int len1 = s.length(), len2 = p.length();
        if (len2 > len1) {
            return result;
        }

        int[] a = new int[26], b = new int[26];
        for (int i = 0; i < len2; i++) {
            a[s.charAt(i) - 'a']++;
            b[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a, b)) {
            result.add(0);
        }

        int left = 0, right = len2;

        while (right < len1) {
            a[s.charAt(left--) - 'a']--;
            a[s.charAt(right++) - 'a']++;
            if (Arrays.equals(a, b)) {
                result.add(left);
            }
        }

        return result;
    }
}

