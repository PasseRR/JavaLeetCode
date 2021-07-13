package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

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
 * "cats and dog",
 * "cat sand dog"
 * ]
 * <p>
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * 示例3：
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

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        // 构建字典树
        for (String word : wordDict) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                node = node.insert(c);
            }
            node.setLeaf();
        }

        List<String> result = new ArrayList<>();
        int len = s.length();
        // null待匹配 false无法匹配单词 true能匹配单词
        // 记忆快速过滤无法匹配单词的节点 索引为字符串位置
        Boolean[] memory = new Boolean[len + 1];

        BiFunction<Integer, StringBuilder, Boolean> backtrack = new BiFunction<Integer, StringBuilder, Boolean>() {
            @Override
            public Boolean apply(Integer index, StringBuilder sb) {
                // 无法匹配的位置
                if (memory[index] != null && !memory[index]) {
                    return false;
                }

                // 匹配完成添加解
                if (index == len) {
                    result.add(sb.toString());
                    return true;
                }

                Trie node = root;
                for (int i = index; i < len; i++) {
                    char c = s.charAt(i);
                    node = node.get(c);
                    // 单词无法匹配
                    if (node == null) {
                        // 记录无法匹配单词的开始位置
                        break;
                    }
                    sb.append(c);
                    // 若是叶子节点 截断单词匹配
                    if (node.isLeaf) {
                        StringBuilder nb = new StringBuilder(sb);
                        // 非单词结尾添加空格
                        if (i + 1 < len) {
                            nb.append(' ');
                        }
                        if (this.apply(i + 1, nb)) {
                            memory[index] = true;
                        }
                    }

                    // 不截断单词匹配
                }

                if (memory[index] == null) {
                    memory[index] = false;
                }

                return memory[index];
            }
        };

        backtrack.apply(0, new StringBuilder());

        return result;
    }
}
