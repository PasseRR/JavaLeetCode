package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 给定一个整数，打印该整数的英文描述。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * <p>
 * 示例 2:
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * 示例 3:
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * 示例 4:
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * @author xiehai
 * @date 2020/08/17 15:51
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1608 {
    // #region snippet
    public String numberToWords(int num) {
        String[] exact = new String[]{
            // 1~19
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            // 20~90
            "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        // 999及以下的数字转英文
        Function<Integer, List<String>> converter = number -> {
            List<String> list = new ArrayList<>();
            int hundred = number / 100;
            // 超过100的只会是个位1~9
            if (hundred > 0) {
                list.add(exact[hundred - 1]);
                list.add("Hundred");
            }

            int left = number % 100;
            // 数字超过20
            if (left >= 20) {
                list.add(exact[left / 10 + 17]);
                left %= 10;
            }

            // 若未超过20 根据索引直接取对应值 超过20只会是1~9
            if (left > 0) {
                list.add(exact[left - 1]);
            }

            return list;
        };

        List<String> result = new ArrayList<>();

        // 单位切换
        String[] unit = new String[]{null, "Thousand", "Million", "Billion"};
        List<Integer> numbers = new ArrayList<>();
        // 从低到高每3为分为一段
        while (num > 0) {
            numbers.add(num % 1000);
            num /= 1000;
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            int section = numbers.get(i);
            // 若段的数字为0 不转换
            if (section > 0) {
                result.addAll(converter.apply(numbers.get(i)));
                // 最低段没有单位
                if (i > 0) {
                    result.add(unit[i]);
                }
            }
        }

        // 只有0
        if (result.isEmpty()) {
            result.add("Zero");
        }

        return String.join(" ", result);
    }
    // #endregion snippet
}
