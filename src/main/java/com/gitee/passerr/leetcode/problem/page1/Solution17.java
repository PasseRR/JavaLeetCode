package com.gitee.passerr.leetcode.problem.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

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
        int length = digits.length();

        BiConsumer<Integer, String> recursion = new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                // 已经到了最后一个字符
                if (integer == length) {
                    result.add(s);
                    return;
                }

                // 对照表索引
                int index = Integer.valueOf(String.valueOf(digits.charAt(integer)));
                for (String letter : DIGITS[index]) {
                    // 递归拼接字符串
                    this.accept(integer + 1, s + letter);
                }
            }
        };

        // 排除空字符串
        if (digits.length() > 0) {
            recursion.accept(0, "");
        }

        return result;
    }
}
