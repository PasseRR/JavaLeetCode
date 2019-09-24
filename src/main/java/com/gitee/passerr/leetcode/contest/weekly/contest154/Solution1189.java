package com.gitee.passerr.leetcode.contest.weekly.contest154;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * @author xiehai1
 * @date 2019/09/24 20:52
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        int[] cache = new int[26];
        // 记录a、b、l、o、n出现次数
        for (Character character : text.toCharArray()) {
            cache[character - 'a']++;
        }
        // l、o减半
        cache['l' - 'a'] /= 2;
        cache['o' - 'a'] /= 2;

        // 最小出现次数则为单词数量
        int min = cache[0];
        for (Character character : "blon".toCharArray()) {
            min = Math.min(min, cache[character - 'a']);
        }

        return min;
    }
}
