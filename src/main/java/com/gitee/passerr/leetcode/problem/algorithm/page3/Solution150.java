package com.gitee.passerr.leetcode.problem.algorithm.page3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * @author xiehai
 * @date 2019/08/07 14:00
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution150 {
    // #region snippet
    static Map<String, BiFunction<Integer, Integer, Integer>> cache = new HashMap<>(4);

    static {
        cache.put("+", (a, b) -> a + b);
        cache.put("-", (a, b) -> a - b);
        cache.put("*", (a, b) -> a * b);
        cache.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // 顺序遍历 遇到符号位 弹出栈中的两个元素作为左值和右值计算
            if (cache.containsKey(token)) {
                int right = stack.pop();
                int left = stack.pop();
                // 计算结果继续入栈
                stack.push(cache.get(token).apply(left, right));
            } else {
                // 若为数字 入栈等待计算
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
    // #endregion snippet
}
