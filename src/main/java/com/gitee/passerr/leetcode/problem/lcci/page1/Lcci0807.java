package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * <p>
 * 示例2:
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * <p>
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 * @author xiehai
 * @date 2020/07/31 13:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0807 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        List<String> result = new ArrayList<>();
        if (chars.length == 0) {
            return new String[0];
        }

        Consumer<Integer> recursion = new Consumer<Integer>() {
            @Override
            public void accept(Integer index) {
                if (index == chars.length) {
                    result.add(new String(chars));
                    return;
                }

                for (int i = index; i < chars.length; i++) {
                    // 选定的字符移动到索引位置 并交换两个位置的字符
                    char temp = chars[index];
                    chars[index] = chars[i];
                    chars[i] = temp;
                    this.accept(index + 1);
                    // 回溯
                    chars[i] = chars[index];
                    chars[index] = temp;
                }
            }
        };
        recursion.accept(0);

        return result.toArray(new String[0]);
    }
}
