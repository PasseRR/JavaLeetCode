package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author xiehai
 * @date 2019/07/09 17:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int length1 = num1.length(), length2 = num2.length();
        // num1的任意位乘以num2
        Function<Integer, String> multiply = index -> {
            StringBuilder sb = new StringBuilder();
            // 乘数
            int multiplier = Integer.valueOf(num1.substring(index, index + 1));
            // 进位
            int carry = 0;
            for (int i = length2 - 1; i >= 0; i--) {
                // 被乘数
                int multiplicand = Integer.valueOf(num2.substring(i, i + 1));
                int product = multiplier * multiplicand + carry;
                carry = product / 10;
                sb.append(product % 10);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            sb.reverse();
            // 倒转后补零
            for (int i = 1; i < length1 - index; i++) {
                sb.append("0");
            }

            return sb.toString();
        };

        // 字符串两数字相加
        BiFunction<String, String, String> add = (addend, summand) -> {
            int i = addend.length() - 1, j = summand.length() - 1, carry = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int n1 = i >= 0 ? Integer.valueOf(addend.substring(i, i + 1)) : 0;
                int n2 = j >= 0 ? Integer.valueOf(summand.substring(j, j + 1)) : 0;
                int sum = n1 + n2 + carry;
                carry = sum > 9 ? 1 : 0;
                sb.append(carry > 0 ? sum - 10 : sum);
                i--;
                j--;
            }

            if (carry > 0) {
                sb.append(carry);
            }

            return sb.reverse().toString();
        };

        List<String> nums = new ArrayList<>();
        for (int i = length1 - 1; i >= 0; i--) {
            nums.add(multiply.apply(i));
        }

        // 数字累加
        String result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = add.apply(result, nums.get(i));
        }

        return result;
    }
}
