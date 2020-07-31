package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * |[
 * |  "((()))",
 * |  "(()())",
 * |  "(())()",
 * |  "()(())",
 * |  "()()()"
 * |]
 * @author xiehai
 * @date 2020/07/31 13:22
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0809 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 若左右括号数一致必须先出现左括号 再出现右括号
        // 若左括号数量大于右括号数量 下一个左右括号均可
        char[] parenthesis = new char[n * 2];
        BiConsumer<Integer, Integer> backtrack = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer left, Integer right) {
                // 右括号数量大于左括号数量或者左括号数量超出
                if (right > left || left > n) {
                    return;
                }
                // 找到满足要求的解
                if (left.equals(right) && left == n) {
                    result.add(new String(parenthesis));
                    return;
                }

                // 先入右括号
                parenthesis[left + right] = '(';
                this.accept(left + 1, right);
                // 再入左括号
                parenthesis[left + right] = ')';
                this.accept(left, right + 1);
            }
        };
        backtrack.accept(0, 0);

        return result;
    }
}
