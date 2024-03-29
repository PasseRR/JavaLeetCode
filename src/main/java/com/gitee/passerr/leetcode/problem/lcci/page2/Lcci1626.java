package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.LinkedList;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * <p>
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * @author xiehai
 * @date 2021/04/19 11:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1626 {
    // #region snippet
    public int calculate(String s) {
        // 使用双向链表
        // 操作数队
        LinkedList<Integer> operands = new LinkedList<>();
        // 操作符队
        LinkedList<Character> operators = new LinkedList<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/': {
                    // 操作符添加在链表尾部
                    operators.addLast(c);
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    int num = c - '0';
                    // 若存在连续数字 测试用例数字应该是连续不会存在数字之间存在空格
                    while ((i + 1) < len && Character.isDigit(s.charAt(i + 1))) {
                        num *= 10;
                        num += s.charAt(i + 1) - '0';
                        i++;
                    }
                    if (!operators.isEmpty()) {
                        char operator = operators.getLast();
                        // 若链表尾是乘法或者除法计算后入队 并移除链表尾操作符
                        if (operator == '*') {
                            operators.removeLast();
                            num *= operands.removeLast();
                        } else if (operator == '/') {
                            operators.removeLast();
                            num = operands.removeLast() / num;
                        }
                    }
                    // 新的操作数添加到链表尾部
                    operands.addLast(num);
                    break;
                }
            }
        }

        // 按照操作数和操作符链表从左到右计算 每次计算结果再添加进链表
        while (!operators.isEmpty()) {
            int left = operands.removeFirst();
            int right = operands.removeFirst();
            if (operators.removeFirst() == '+') {
                operands.addFirst(left + right);
            } else {
                operands.addFirst(left - right);
            }
        }

        return operands.removeFirst();
    }
    // #endregion snippet
}
