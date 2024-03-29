package com.gitee.passerr.leetcode.problem.lcci.page3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。
 * 不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 * <p>
 * 示例 1:
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * .[
 * .  "this",
 * .  "real",
 * .  "hard"
 * .]
 * <p>
 * 示例 2:
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * <p>
 * 说明：
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 * @author xiehai
 * @date 2021/06/24 15:55
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1725 {
    // #region snippet
    static class Trie {
        // 字典树
        Trie[] children = new Trie[26];
        // 是否叶子节点
        boolean isLeaf = false;

        Trie addChild(char c) {
            int index = c - 'a';
            if (this.children[index] == null) {
                this.children[index] = new Trie();
            }

            return this.children[index];
        }

        Trie getChild(char c) {
            return this.children[c - 'a'];
        }

        void setLeaf() {
            if (!this.isLeaf) {
                this.isLeaf = true;
            }
        }
    }

    public String[] maxRectangle(String[] words) {
        Map<Integer, Set<String>> groupByLength = new HashMap<>(8);
        Trie root = new Trie();
        // 0最大单词长度 1最大面积
        int[] max = new int[2];
        max[0] = Integer.MIN_VALUE;
        for (String word : words) {
            int len = word.length();
            // 按照单词长度分组
            groupByLength.putIfAbsent(len, new HashSet<>());
            groupByLength.get(len).add(word);
            // 记录最大单词长度
            max[0] = Integer.max(max[0], len);

            // 构建字典树
            Trie node = root;
            for (char c : word.toCharArray()) {
                node = node.addChild(c);
            }
            node.setLeaf();
        }

        List<String> result = new ArrayList<>();
        // 是否匹配
        BiFunction<List<String>, Integer, Integer> isValid = (list, len) -> {
            boolean allMatch = true;
            for (int i = 0; i < len; i++) {
                Trie node = root;
                // 垂直方向字符串
                for (String s : list) {
                    Trie child = node.getChild(s.charAt(i));
                    if (child == null) {
                        return 0;
                    }

                    node = child;
                }

                // 不是单词的最后节点
                if (!node.isLeaf) {
                    allMatch = false;
                }
            }

            // 1部分匹配 2完全匹配
            return allMatch ? 2 : 1;
        };
        BiConsumer<Map.Entry<Integer, Set<String>>, List<String>> backtrack =
            new BiConsumer<Map.Entry<Integer, Set<String>>, List<String>>() {
                @Override
                public void accept(Map.Entry<Integer, Set<String>> entry, List<String> list) {
                    // 单词长度
                    int len = entry.getKey();
                    // 超过最大面积或者最优解不能超过当前最大面积
                    // 最终面积为横竖单词长度的乘积
                    if (list.size() > max[0] || len * max[0] < max[1]) {
                        return;
                    }

                    for (String s : entry.getValue()) {
                        list.add(s);
                        Integer apply = isValid.apply(list, len);
                        if (apply >= 1) {
                            // 完全匹配时更新最大面积及最优解
                            if (apply == 2) {
                                int area = list.size() * len;
                                if (area > max[1]) {
                                    max[1] = area;
                                    result.clear();
                                    result.addAll(new ArrayList<>(list));
                                }
                            }

                            // 完全匹配或者未完全匹配都继续遍历
                            this.accept(entry, list);
                        }

                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
            };

        for (Map.Entry<Integer, Set<String>> entry : groupByLength.entrySet()) {
            backtrack.accept(entry, new ArrayList<>());
        }

        return result.toArray(new String[0]);
    }
    // #endregion snippet
}
