package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @author xiehai
 * @date 2019/07/24 16:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();

        BiConsumer<Integer, List<String>> backtrack = new BiConsumer<Integer, List<String>>() {
            @Override
            public void accept(Integer start, List<String> list) {
                // 长度太短
                if (start > length) {
                    return;
                }

                // 找到4个组成ip的数字
                if (list.size() == 4) {
                    // 字符串刚好用完则为解
                    if (start == length) {
                        result.add(String.join(".", list));
                    }
                    return;
                }

                // ip最多由3位数字组成
                for (int i = 0; i < 3 && (start + i) < length; i++) {
                    String section = s.substring(start, start + i + 1);
                    if (Integer.parseInt(section) < 256) {
                        // 如果数字长度大于1且以0开头 非法数字结束
                        if (i > 0 && s.charAt(start) == '0') {
                            break;
                        }
                        list.add(section);
                        this.accept(start + i + 1, list);
                        // 回溯
                        list.remove(list.size() - 1);
                    }
                }
            }
        };

        backtrack.accept(0, new ArrayList<>());

        return result;
    }
}
