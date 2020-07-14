package com.gitee.passerr.leetcode.problem.lcof.page1;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * @author xiehai
 * @date 2020/07/14 12:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof38 {
    public String[] permutation(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        Set<String> result = new HashSet<>();
        Consumer<Integer> backtrack = new Consumer<Integer>() {
            @Override
            public void accept(Integer index) {
                if (index == len) {
                    result.add(new String(chars));
                    return;
                }
                // index位置已经使用过的字符 去重
                Set<Character> used = new HashSet<>();
                for (int i = index; i < len; i++) {
                    if (!used.contains(chars[i])) {
                        used.add(chars[i]);
                        // 交换字符位置 保证index之后的字符都是未使用过的
                        char temp = chars[index];
                        chars[index] = chars[i];
                        chars[i] = temp;

                        this.accept(index + 1);
                        // 回溯
                        chars[i] = chars[index];
                        chars[index] = temp;
                    }
                }
            }
        };
        backtrack.accept(0);

        return result.toArray(new String[0]);
    }
}
