package com.gitee.passerr.leetcode.problem.lcci.page3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * <p>
 * 解释:endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * @author xiehai
 * @date 2021/06/11 14:35
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1722 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        // 开始单词或结束单词不存在与字典中
        if (!words.contains(endWord)) {
            return Collections.emptyList();
        }

        // 是否满足转换条件 两个单词只能有一个字母不同
        BiPredicate<String, String> isCondition = (s, t) -> {
            int len = s.length(), cnt = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                }
            }

            return cnt == 1;
        };

        List<String> result = new ArrayList<>(), dict = new ArrayList<>(words);
        int len = dict.size();
        // 标记已经使用过的单词
        int[] visited = new int[len];
        Function<String, Boolean> backtrack = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String prefix) {
                result.add(prefix);
                if (Objects.equals(prefix, endWord)) {
                    return true;
                }

                for (int i = 0; i < len; i++) {
                    String word = dict.get(i);
                    if (visited[i] == 0 && isCondition.test(prefix, word)) {
                        visited[i] = 1;
                        Boolean apply = this.apply(word);
                        // 找到解 直接结束
                        if (apply) {
                            return true;
                        }
                        // 回溯
                        result.remove(result.size() - 1);
                    }
                }

                return false;
            }
        };

        if (backtrack.apply(beginWord)) {
            return new ArrayList<>(result);
        }

        return Collections.emptyList();
    }
}
