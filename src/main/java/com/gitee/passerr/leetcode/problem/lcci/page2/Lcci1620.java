package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
 * 给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * <p>
 * 示例 2:
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * <p>
 * 提示：
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 * @author xiehai
 * @date 2021/03/23 10:08
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1620 {
    // #region snippet
    public List<String> getValidT9Words(String num, String[] words) {
        // 字典对应关系
        char[] dict = new char[]{
            '2', '2', '2',
            '3', '3', '3',
            '4', '4', '4',
            '5', '5', '5',
            '6', '6', '6',
            '7', '7', '7', '7',
            '8', '8', '8',
            '9', '9', '9', '9'
        };

        return
            Arrays.stream(words)
                .filter(word ->
                    IntStream.range(0, word.length())
                        .allMatch(it -> num.charAt(it) == dict[word.charAt(it) - 'a'])
                )
                .collect(Collectors.toList());
    }
    // #endregion snippet
}
