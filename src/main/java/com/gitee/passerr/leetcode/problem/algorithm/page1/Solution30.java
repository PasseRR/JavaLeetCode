package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * @author xiehai
 * @date 2019/07/04 16:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        // 若s长度小于words总长度 则没有解
        // 单个单词长度
        int singleLength = words.length > 0 ? words[0].length() : 0;
        // 单词数组单词总长度
        int totalLength = words.length * singleLength;
        int length = s.length();
        // 数组为空或长度不满足 直接返回
        if (words.length == 0 || length < totalLength) {
            return result;
        }

        // 单词出现次数映射
        Map<String, Long> wordsCount = new HashMap<>(
            Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );

        for (int i = 0; i <= length - totalLength; i++) {
            Map<String, Long> snapshot = new HashMap<>(wordsCount);
            for (int j = 0; j < words.length; j++) {
                // 根据单词长度截取出来的单词
                String word = s.substring(i + singleLength * j, i + singleLength * (j + 1));
                // 单词匹配 计数减一并移除计数为0的单词
                if (snapshot.containsKey(word)) {
                    snapshot.compute(word, (k, v) -> v - 1);
                    snapshot.remove(word, 0L);
                } else {
                    break;
                }
            }
            // 所有单词刚好匹配完成
            if (snapshot.isEmpty()) {
                result.add(i);
            }
        }

        return result;
    }
}
