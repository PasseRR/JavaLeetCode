package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * @author xiehai
 * @date 2019/08/08 17:39
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution139 {
    static class Trie {
        Trie[] children = new Trie[26];
        boolean isLeaf;

        Trie insert(char c) {
            Trie trie = this.get(c);
            if (trie != null) {
                return trie;
            }

            trie = new Trie();
            this.children[c - 'a'] = trie;

            return trie;
        }

        Trie get(char c) {
            return this.children[c - 'a'];
        }

        void setLeaf() {
            this.isLeaf = true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        // 构建字典树
        for (String word : wordDict) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                node = node.insert(c);
            }
            node.setLeaf();
        }

        int len = s.length();
        // 记录访问过的位置
        Set<Integer> visited = new HashSet<>();
        Function<Integer, Boolean> backtrack = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer index) {
                if (index == len) {
                    return true;
                }

                Trie node = root;
                for (int i = index; i < len; i++) {
                    node = node.get(s.charAt(i));
                    if (node == null) {
                        break;
                    }

                    // 截断单词
                    if (node.isLeaf && !visited.contains(i + 1) && this.apply(i + 1)) {
                        return true;
                    }

                    // 不截断继续匹配
                }

                visited.add(index);
                return false;
            }
        };

        return backtrack.apply(0);
    }
}
