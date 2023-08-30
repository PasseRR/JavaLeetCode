package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * @author xiehai
 * @date 2019/07/16 11:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution65 {
    // #region snippet
    public boolean isNumber(String s) {
        String trim = s.trim();
        // 是否是合法整数
        Function<String, Boolean> isValidInteger = string -> {
            // 数字分为小数与整数且可以以符号开头
            if (string.startsWith("-") || string.startsWith("+")) {
                string = string.substring(1);
            }
            for (int i = 0, length = string.length(); i < length; i++) {
                if (string.charAt(i) < '0' || string.charAt(i) > '9') {
                    return false;
                }
            }

            return !string.isEmpty();
        };
        // 是否是合法小数
        Function<String, Boolean> isValidFloat = string -> {
            // 数字分为小数与整数且可以以符号开头
            if (string.startsWith("-") || string.startsWith("+")) {
                string = string.substring(1);
            }
            // 是否存在小数点
            boolean hasPoint = false;
            boolean hasNumber = false;
            for (int i = 0, length = string.length(); i < length; i++) {
                if (string.charAt(i) == '.' && !hasPoint) {
                    hasPoint = true;
                } else if ((string.charAt(i) == '.' && hasPoint) || string.charAt(i) < '0' || string.charAt(i) > '9') {
                    return false;
                } else {
                    // 存在数字
                    hasNumber = true;
                }
            }

            return hasNumber && hasPoint;
        };
        // 是否是合法数字
        Function<String, Boolean> isValidNumber = string ->
            s.contains(".") ? isValidFloat.apply(string) : isValidInteger.apply(string);
        // 是否是合法指数
        BiFunction<String, String, Boolean> isValidExponential = (head, tail) ->
            isValidNumber.apply(head) && isValidInteger.apply(tail);
        // 是否是合法數字
        Function<String, Boolean> isNumber = string -> {
            int indexOfE = string.indexOf('e');
            return indexOfE > -1
                ? isValidExponential.apply(string.substring(0, indexOfE), string.substring(indexOfE + 1))
                : isValidNumber.apply(string);
        };

        return isNumber.apply(trim);
    }
    // #endregion snippet
}
