package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.function.BiPredicate;

/**
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典wordList 中的单词。
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，找到从beginWord 到endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 * <p>
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * <p>
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 提示：
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * @author xiehai
 * @date 2021/07/16 09:51
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>(Collections.singleton(beginWord));
        // 从开始单词开始 已经有一个序列了
        int result = 1, len = beginWord.length();
        // 两个单词是否能转换
        BiPredicate<String, String> canTransform = (s1, s2) -> {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                    // 卫语句
                    if (diff > 1) {
                        return false;
                    }
                }
            }

            return diff == 1;
        };

        // bfs
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            // 遍历当前变换次数的所有单词
            while (size > 0) {
                String poll = queue.poll();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    if (canTransform.test(poll, s)) {
                        if (s.equals(endWord)) {
                            return result;
                        }
                        // 下一次bfs遍历
                        queue.offer(s);
                        // 移除已使用的元素
                        iterator.remove();
                    }
                }
                size--;
            }
        }

        return 0;
    }
}
