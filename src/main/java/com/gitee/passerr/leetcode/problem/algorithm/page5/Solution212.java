package com.gitee.passerr.leetcode.problem.algorithm.page5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：
 * board = [
 * ["o","a","a","n"],
 * ["e","t","a","e"],
 * ["i","h","k","r"],
 * ["i","f","l","v"]
 * ],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * @author xiehai
 * @date 2021/07/13 13:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution212 {
    static class Trie {
        Trie[] children = new Trie[26];
        boolean isLeaf;
        // 若是叶子节点 记录字符串的值
        String value;

        Trie add(char c) {
            int index = index(c);
            if (this.children[index] == null) {
                this.children[index] = new Trie();
            }

            return this.children[index];
        }

        Trie get(char c) {
            return this.children[index(c)];
        }

        void setLeaf(String value) {
            this.isLeaf = true;
            this.value = value;
        }

        static int index(char c) {
            return c - 'a';
        }
    }

    interface TrConsumer<P1, P2, P3> {
        /**
         * 消费方法
         * @param p1 参数1
         * @param p2 参数2
         * @param p3 参数3
         */
        void accept(P1 p1, P2 p2, P3 p3);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        // 构建字典树
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                node = node.add(c);
            }
            node.setLeaf(word);
        }

        List<String> result = new ArrayList<>();
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        // 回溯
        TrConsumer<Integer, Integer, Trie> backtrack = new TrConsumer<Integer, Integer, Trie>() {
            @Override
            public void accept(Integer row, Integer column, Trie trie) {
                // 索引越界
                if (row < 0 || column < 0 || row >= rows || column >= columns) {
                    return;
                }
                // 同一次遍历重复遍历
                if (visited[row][column]) {
                    return;
                }
                char letter = board[row][column];
                Trie child = trie.get(letter);
                // 不存在前缀
                if (child == null) {
                    return;
                }
                visited[row][column] = true;
                if (child.isLeaf) {
                    result.add(child.value);
                    // 如果已经找到这个单词 设置这个节点为非叶子节点 避免重复遍历
                    child.isLeaf = false;
                }
                this.accept(row, column + 1, child);
                this.accept(row, column - 1, child);
                this.accept(row + 1, column, child);
                this.accept(row - 1, column, child);
                // 回溯
                visited[row][column] = false;
            }
        };

        // 以每个字符为根节点遍历字典树
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                backtrack.accept(i, j, root);
            }
        }

        return result;
    }
}
