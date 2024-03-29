package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/**
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"
 * 已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，
 * 你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，
 * 要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * <p>
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * @author xiehai
 * @date 2021/05/19 15:24
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1713 {
    // #region snippet
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        // 按照字典第一个字符缓存 用于快速查找匹配前缀 使用set去重字典
        Map<Character, Set<String>> cache = new HashMap<>(8);
        for (String s : dictionary) {
            if (s.length() <= len) {
                cache.merge(s.charAt(0), new HashSet<>(Collections.singletonList(s)), (o, n) -> {
                    o.addAll(n);
                    return o;
                });
            }
        }


        // 记忆 缓存索引位置之前未识别字符最小数量
        int[] memory = new int[len + 1];
        Arrays.fill(memory, len + 1);
        AtomicInteger result = new AtomicInteger(len);
        BiConsumer<Integer, Integer> backtrack = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer index, Integer count) {
                // 未识别字符已经大于等于当前最小值直接结束 或者已经为最小值
                if (index > len || memory[index] <= count || memory[index] == 0) {
                    return;
                }

                // 数据缓存
                // 表示index之前最小未识别字符数量
                memory[index] = Integer.min(memory[index], count);

                // 匹配完成
                if (index == len) {
                    // 记录并更新最小值
                    result.set(Integer.min(count, result.get()));
                    return;
                }

                cache.getOrDefault(sentence.charAt(index), new HashSet<>())
                    .stream()
                    // 过滤出前缀完全匹配的字典
                    .filter(it -> it.length() <= (len - index) && sentence.substring(index).startsWith(it))
                    .forEach(it -> this.accept(index + it.length(), count));

                // 不匹配字典
                this.accept(index + 1, count + 1);
            }
        };

        backtrack.accept(0, 0);

        return result.get();
    }
    // #endregion snippet
}
