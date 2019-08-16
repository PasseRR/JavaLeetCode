package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * <p>
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * @author xiehai
 * @date 2019/08/08 18:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        // 缓存索引位置开始能匹配的单词句子
        Map<Integer, List<String>> cache = new HashMap<>(8);
        // 单词完全匹配成句子 终止位置
        cache.put(length, Collections.singletonList(""));

        // 递归处理
        Function<Integer, List<String>> recursion = new Function<Integer, List<String>>() {
            @Override
            public List<String> apply(Integer from) {
                // from索引处开始可以匹配的单词句子
                List<String> solutions = new ArrayList<>();
                for (String word : wordDict) {
                    // from开始的子字符串是否以单词开头
                    if (s.substring(from).startsWith(word)) {
                        // 下一索引
                        Integer next = from + word.length();
                        // 缓存中存在 直接使用缓存 否则递归计算可组成的句子
                        List<String> apply = cache.containsKey(next) ? cache.get(next) : this.apply(next);
                        // 若结果为空 表示from处子字符串不能用词典中的单词组成句子
                        if (!apply.isEmpty()) {
                            // 句子若是空字符串 表示已经匹配到s末尾 若是非空 找到一个子句
                            apply.stream().map(it -> it.isEmpty() ? word : word + " " + it).forEach(solutions::add);
                        }
                    }
                }

                // 缓存
                cache.put(from, solutions);

                return solutions;
            }
        };

        return recursion.apply(0);
    }

    public List<String> wordBreakTle(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        int length = s.length();

        // 直接使用回溯TLE了
        BiConsumer<Integer, StringBuilder> backtrack = new BiConsumer<Integer, StringBuilder>() {
            @Override
            public void accept(Integer from, StringBuilder line) {
                if (from == length) {
                    result.add(line.toString());
                    return;
                }
                for (String word : wordDict) {
                    if (s.substring(from).startsWith(word)) {
                        if (line.length() > 0) {
                            line.append(" ");
                        }
                        line.append(word);
                        this.accept(from + word.length(), line);
                        if (line.length() > 0) {
                            line.delete(line.length() - 1, line.length());
                        }
                    }
                }
            }
        };
        backtrack.accept(0, new StringBuilder());

        return result;
    }
}
