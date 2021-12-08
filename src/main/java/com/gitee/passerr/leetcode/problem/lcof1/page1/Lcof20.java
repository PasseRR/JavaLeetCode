package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.function.Function;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * @author xiehai
 * @date 2020/07/04 15:10
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof20 {
    private static final String EXPONENT = "e";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String POINT = ".";

    public boolean isNumber(String s) {
        // 是否是无符号整数
        Function<String, Boolean> isUnsignedInteger = num -> {
            // 整数不能为空
            if (num.isEmpty()) {
                return false;
            }

            for (char c : num.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        };

        // 是否是整数
        Function<String, Boolean> isInteger = num ->
            // 若是正负号开头 去掉符号
            isUnsignedInteger.apply(num.substring(num.startsWith(PLUS) || num.startsWith(MINUS) ? 1 : 0));

        // 是否是小数 小数可以以小数点开头 也可以以小数点结尾
        Function<String, Boolean> isDecimal = num -> {
            // 去掉符号
            if (num.startsWith(PLUS) || num.startsWith(MINUS)) {
                num = num.substring(1);
            }

            int index = num.indexOf(POINT);

            return
                // 小数不能只有一位
                index >= 0 && num.length() > 1
                    // 小数点左边为有符号整数或为空(小数点在第一位)
                    ? (index == 0 || isInteger.apply(num.substring(0, index)))
                    // 右边为无符号整数或为空(小数点在最后一位)
                    && (index == num.length() - 1 || isUnsignedInteger.apply(num.substring(index + 1)))
                    // 没有小数点表名是个整数
                    : isInteger.apply(num);
        };

        // 是否是科学计数 底数可为小数或者整数 指数必须为整数
        Function<String, Boolean> isScientific = num -> {
            // 指数标识位置
            int index = num.indexOf(EXPONENT);

            return
                // 指数标识不能是第一个
                index > 0
                    // 底数可为数字 指数必须为整数
                    ? isDecimal.apply(num.substring(0, index)) && isInteger.apply(num.substring(index + 1))
                    // 没有指数标识 说明是个数字
                    : isDecimal.apply(num);
        };

        return isScientific.apply(s.trim());
    }
}
