package com.gitee.passerr.leetcode.problem.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author xiehai
 * @date 2019/07/03 09:43
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution17 {
    /**
     * 数字与字母对照表
     */
    private static final String[][] DIGITS = new String[][]{
        {},
        {},
        {"a", "b", "c"},
        {"d", "e", "f"},
        {"g", "h", "i"},
        {"j", "k", "l"},
        {"m", "n", "o"},
        {"p", "q", "r", "s"},
        {"t", "u", "v"},
        {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 组合迭代
        IntConsumer combination = index -> {
            if (result.isEmpty()) {
                result.addAll(Arrays.asList(DIGITS[index]));
            } else {
                List<String> snapshot = new ArrayList<>(result);
                result.clear();
                snapshot.stream()
                    .map(item ->
                        Arrays.stream(DIGITS[index])
                            .map(letter -> item + letter)
                            .collect(Collectors.toList())
                    ).forEach(result::addAll);
            }
        };

        // 字符遍历
        IntStream.range(0, digits.length())
            .map(index -> Integer.valueOf(String.valueOf(digits.charAt(index))))
            .forEach(combination);

        return result;
    }
}
