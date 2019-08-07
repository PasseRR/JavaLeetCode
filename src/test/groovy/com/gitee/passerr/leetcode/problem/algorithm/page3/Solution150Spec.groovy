package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution150}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 14:07
 * @author xiehai
 */
class Solution150Spec extends Specification {
    Solution150 solution150 = new Solution150()

    @Unroll
    def "evalRPN(#tokens) = #result"() {
        expect:
        result == this.solution150.evalRPN(tokens)

        where:
        tokens                                                                            || result
        ["18"] as String[]                                                                || 18
        ["2", "1", "+", "3", "*"] as String[]                                             || 9
        ["4", "13", "5", "/", "+"] as String[]                                            || 6
        ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] as String[] || 22
    }
}
