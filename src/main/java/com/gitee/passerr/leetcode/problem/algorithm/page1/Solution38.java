package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.function.Function;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * @author xiehai
 * @date 2019/07/09 09:40
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution38 {
    // #region snippet
    public String countAndSay(int n) {
        Function<Integer, String> generator = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                if (integer == 1) {
                    return "1";
                } else {
                    // 递归报数
                    String s = this.apply(integer - 1);
                    int count = 1;
                    char temp = s.charAt(0);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1, length = s.length(); i < length; i++) {
                        if (temp == s.charAt(i)) {
                            count++;
                        } else {
                            sb.append(count).append(temp);
                            temp = s.charAt(i);
                            count = 1;
                        }
                    }

                    // 末尾遗留
                    if (count > 0) {
                        sb.append(count).append(temp);
                    }

                    return sb.toString();
                }
            }
        };

        return generator.apply(n);
    }
    // #endregion snippet
}
