package com.gitee.passerr.leetcode.problem.page1;

import java.util.Arrays;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @author xiehai
 * @date 2019/07/05 14:15
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        // 表记录括号对是否匹配
        int[] records = new int[length];
        Arrays.fill(records, -1);

        for (int i = 0; i < length; i++) {
            // 如果字符为)
            if (s.charAt(i) == ')') {
                int index = i;
                while (--index >= 0) {
                    // 向索引之前找是否有值为0的( 若有更新两个对应位置的值为1
                    if (records[index] == 0) {
                        records[index] = 1;
                        records[i] = 1;
                        break;
                    }
                }
            } else {
                // 若是(括号 更新记录表值为0 等待匹配
                records[i] = 0;
            }
        }

        int result = 0, total = 0;
        // 遍历记录表 遇到值小于1的表示括号对断层
        // 累加值即位当前括号段的有效括号数
        for (int i = 0; i < length; i++) {
            if (records[i] > 0) {
                total += 1;
            } else {
                if (total > result) {
                    result = total;
                }
                total = 0;
            }
        }

        // 找到最后依然是有效的括号对 和当前最大值比较 返回的较大一个
        return total > result ? total : result;
    }
}
