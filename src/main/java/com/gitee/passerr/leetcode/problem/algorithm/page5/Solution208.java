package com.gitee.passerr.leetcode.problem.algorithm.page5;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 * @author xiehai
 * @date 2021/07/12 09:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution208 {
}

class Trie {
    Trie[] children;
    boolean isLeaf;

    public Trie() {
        this.children = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.doInsert(index(c));
        }
        node.setLeaf();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            Trie child = node.child(index(c));
            if (child == null) {
                return false;
            }

            node = child;
        }

        return node.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            Trie child = node.child(index(c));
            if (child == null) {
                return false;
            }

            node = child;
        }

        return true;
    }

    protected Trie doInsert(int index) {
        if (this.child(index) == null) {
            this.children[index] = new Trie();
        }

        return this.child(index);
    }

    protected Trie child(int index) {
        return this.children[index];
    }

    protected static int index(char c) {
        return c - 'a';
    }

    protected void setLeaf() {
        this.isLeaf = true;
    }
}
