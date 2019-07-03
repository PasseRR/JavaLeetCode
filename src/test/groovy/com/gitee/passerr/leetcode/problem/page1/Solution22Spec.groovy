package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution22}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 16:06
 * @author xiehai
 */
class Solution22Spec extends Specification {
    Solution22 solution22 = new Solution22()

    @Unroll
    def "generateParenthesis(#input) = #result"() {
        expect:
        result == this.solution22.generateParenthesis(input)

        where:
        input || result
        0     || []
        1     || ["()"]
        2     || ["()()", "(())"]
        3     || ["()()()", "()(())", "(())()", "((()))", "(()())"]
    }
}
