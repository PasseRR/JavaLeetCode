package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，
 * 一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
 * 如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * <p>
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 * <p>
 * 提示：
 * 1 <= beginWord.length <= 7
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 * @author xiehai
 * @date 2021/07/19 11:34
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution126 {
    static class Trie {
        Map<String, Trie> children = new HashMap<>();
        Trie parent;
        String value;

        Trie(String value) {
            this(null, value);
        }

        Trie(Trie parent, String value) {
            this.parent = parent;
            this.value = value;
        }

        Trie add(String s) {
            this.children.putIfAbsent(s, new Trie(this, s));
            return this.children.get(s);
        }

        Trie addIfLadder(String s) {
            int cnt = 0;
            for (int i = 0, len = s.length(); i < len; i++) {
                if (s.charAt(i) != this.value.charAt(i)) {
                    cnt++;
                    if (cnt > 1) {
                        break;
                    }
                }
            }

            if (cnt != 1) {
                return null;
            }

            return this.add(s);
        }

        List<String> result() {
            ArrayDeque<String> deque = new ArrayDeque<>();

            Trie node = this;
            while (node != null) {
                deque.offerFirst(node.value);
                node = node.parent;
            }

            return new ArrayList<>(deque);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 字典树 key为前置单词
        Trie root = new Trie(beginWord);
        // bfs根节点
        Queue<Trie> queue = new ArrayDeque<>(Collections.singleton(root));
        Set<String> copy = new HashSet<>(wordList);
        List<Trie> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> toBeRemoved = new HashSet<>();
            while (size > 0) {
                Trie trie = queue.poll();
                assert trie != null;
                for (String s : copy) {
                    // 满足转换条件则放入字典树中
                    Trie t = trie.addIfLadder(s);
                    if (t != null) {
                        queue.add(t);
                        toBeRemoved.add(s);

                        // 满足结果的最优路径
                        if (s.equals(endWord)) {
                            result.add(t);
                        }
                    }
                }

                size--;
            }

            // bfs找到最短路径
            if (!result.isEmpty()) {
                break;
            }

            // 移除已使用的单词
            // 在同样长度的转换过程 一个单词可以被使用多次
            copy.removeAll(toBeRemoved);
        }

        return result.stream().map(Trie::result).collect(Collectors.toList());
    }
}
