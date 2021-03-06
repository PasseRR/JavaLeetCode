package com.gitee.passerr.leetcode.contest.season.fall2020;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，
 * 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。
 * 每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * <p>
 * 示例 1：
 * 输入：leaves = "rrryyyrryyyrr"
 * 输出：2
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 * <p>
 * 示例 2：
 * 输入：leaves = "ryr"
 * 输出：0
 * 解释：已符合要求，不需要额外操作
 * <p>
 * 提示：
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 * @author xiehai
 * @date 2020/09/12 15:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution3 {
    public int minimumOperations(String leaves) {
        List<Integer> sections = new ArrayList<>();
        char c = leaves.charAt(0);
        int count = 1;
        for (int i = 1; i < leaves.length(); i++) {
            if (c == leaves.charAt(i)) {
                count++;
            } else {
                sections.add(count * (c == 'r' ? 1 : -1));
                c = leaves.charAt(i);
                count = 1;
            }
        }
        sections.add(count * (c == 'r' ? 1 : -1));
        int size = sections.size();
        if (size == 1) {
            return 2;
        }
        // 段数大于1
        // 段落分部必然是正负交错
        Function<Integer, Integer> backtrack = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer index) {
                return null;
            }
        };
        int init = sections.get(0) > 0 ? 0 : sections.get(0);
        return 0;
    }
}
