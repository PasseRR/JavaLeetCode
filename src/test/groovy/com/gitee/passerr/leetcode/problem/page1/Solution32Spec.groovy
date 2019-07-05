package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution32}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/05 14:24
 * @author xiehai
 */
class Solution32Spec extends Specification {
    Solution32 solution32 = new Solution32()

    @Unroll
    def "longestValidParentheses(#input) = #result"() {
        expect:
        result == this.solution32.longestValidParentheses(input)

        where:
        input    || result
        "()()()" || 6
        "(()"    || 2
        ")()())" || 4
        "()(()"  || 2
        ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())" || 132
    }
}
