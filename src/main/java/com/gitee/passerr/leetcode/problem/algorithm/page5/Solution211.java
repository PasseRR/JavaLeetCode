package com.gitee.passerr.leetcode.problem.algorithm.page5;

import java.util.Arrays;
import java.util.Objects;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。
 * word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 * <p>
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * <p>
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * @author xiehai
 * @date 2021/07/13 10:54
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution211 {
}

class WordDictionary {
    WordDictionary[] children;
    boolean isLeaf;

    public WordDictionary() {
        this.children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new WordDictionary();
            }

            node = node.children[c - 'a'];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        WordDictionary node = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            // 占位符匹配
            if (c == '.') {
                String section = word.substring(i + 1);
                return
                    Arrays.stream(node.children)
                        .filter(Objects::nonNull)
                        .anyMatch(it -> it.search(section));
            }

            // 非占位符 字典匹配
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }

        return node.isLeaf;
    }
}
