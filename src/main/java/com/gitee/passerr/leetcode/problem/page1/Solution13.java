package com.gitee.passerr.leetcode.problem.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author xiehai
 * @date 2019/07/02 15:21
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution13 {
    private static final Map<String, Integer> ROMAN = new HashMap<>(8);

    static {
        ROMAN.put("M", 1000);
        ROMAN.put("CM", 900);
        ROMAN.put("D", 500);
        ROMAN.put("CD", 400);
        ROMAN.put("C", 100);
        ROMAN.put("XC", 90);
        ROMAN.put("L", 50);
        ROMAN.put("XL", 40);
        ROMAN.put("X", 10);
        ROMAN.put("IX", 9);
        ROMAN.put("V", 5);
        ROMAN.put("IV", 4);
        ROMAN.put("I", 1);
    }

    public int romanToInt(String s) {
        int result = 0, length = s.length(), i = 0;
        String key;
        int temp;
        while (i < length) {
            // 两个字符串组合是否包含
            if (i + 1 < length && ROMAN.containsKey(key = s.substring(i, i + 2))) {
                temp = ROMAN.get(key);
                i += 2;
            } else {
                // 单个字符值获取
                temp = ROMAN.get(s.substring(i, i + 1));
                i++;
            }

            result += temp;
        }

        return result;
    }
}
