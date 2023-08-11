package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * <p>
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出：""
 * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 10<sup>5</sup>
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * <p>
 * 注意：本题与主站 76题相似（本题答案不唯一）：https://leetcode.cn/problems/minimum-window-substring/
 * @author xiehai
 * @date 2021/12/17 16:34
 */
public class Lcof017 {
    public String minWindow(String s, String t) {
        int len = s.length();
        // 待匹配的字符及数量
        Map<Character, Integer> map = new HashMap<>();
        // 待匹配的所有字符个数
        for (char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }


        char c;
        String result = "";
        int[] cnt = new int[1];
        int left = 0, right = 0, need = map.size();

        while (right < len) {
            c = s.charAt(right);

            map.computeIfPresent(c, (k, v) -> {
                // 刚好是从1到0 则表示k这个字符已经匹配完成 即这个字符待匹配数量从 1 -> 0
                if (Objects.equals(v, 1)) {
                    // 匹配完成字符数量增加
                    cnt[0]++;
                }
                return v - 1;
            });

            // 如果已经匹配完成 从左向右滑动窗口
            while (cnt[0] == need) {
                // 匹配完成的字符串比较 缓存最短字符串
                if (result.isEmpty() || (right - left + 1) < result.length()) {
                    result = s.substring(left, right + 1);
                }

                // 收缩左边界
                map.computeIfPresent(s.charAt(left), (k, v) -> {
                    // 刚好恢复一个匹配完成的字符 即这个字符待匹配数量从0 -> 1
                    if (Objects.equals(v, 0)) {
                        // 匹配完成字符数量减少
                        cnt[0]--;
                    }

                    return v + 1;
                });
                left++;
            }

            right++;
        }

        return result;
    }
}
