package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof036}单元测试
 * @date 2022/01/11 09:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof036Spec extends Specification {
    Lcof036 lcof036 = new Lcof036()

    @Unroll
    def "evalRPN(#tokens) = #result"() {
        expect:
        result == this.lcof036.evalRPN(tokens)

        where:
        tokens                                                                            || result
        ["2", "1", "+", "3", "*"] as String[]                                             || 9
        ["4", "13", "5", "/", "+"] as String[]                                            || 6
        ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] as String[] || 22
    }
}
