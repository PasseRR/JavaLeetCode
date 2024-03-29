package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * <p>
 * 示例：
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * <p>
 * 提示：
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 * @author xiehai
 * @date 2021/05/26 17:24
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1715 {
    // #region snippet
    public String longestWord(String[] words) {
        // 按照单词第一个字符缓存
        Map<Character, Set<String>> cache = new HashMap<>(8);
        for (String word : words) {
            if (!word.isEmpty()) {
                cache.merge(word.charAt(0), new HashSet<>(Collections.singletonList(word)), (o, n) -> {
                    o.addAll(n);
                    return o;
                });
            }
        }

        // 按照字符串长度倒叙排列 长度相同按照字典升序
        Arrays.sort(words, (a, b) -> {
            int compare = Integer.compare(b.length(), a.length());
            return compare == 0 ? a.compareTo(b) : compare;
        });

        // 按照前缀回溯
        BiFunction<String, String, Boolean> backtrack = new BiFunction<String, String, Boolean>() {
            @Override
            public Boolean apply(String source, String target) {
                if (target.isEmpty()) {
                    return true;
                }

                Set<String> hit = cache.getOrDefault(target.charAt(0), new HashSet<>());
                for (String c : hit) {
                    // 满足不是源单词
                    if (!c.equals(source)
                        // 长度小于带匹配字符串
                        && c.length() <= target.length()
                        // 待匹配字符串与当前字符串开头
                        && target.startsWith(c)
                        // 剩余字符串都在字典中
                        && this.apply(source, target.substring(c.length()))) {
                        return true;
                    }
                }

                return false;
            }
        };

        // 按照满足结果要求倒叙 第一个满足单词组合的则为结果
        for (String word : words) {
            if (!word.isEmpty() && backtrack.apply(word, word)) {
                return word;
            }
        }

        return "";
    }
    // #endregion snippet
}
