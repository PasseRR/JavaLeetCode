package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution29}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 15:42
 * @author xiehai
 */
class Solution29Spec extends Specification {
    Solution29 solution29 = new Solution29()

    @Unroll
    def "divide(#dividend, #divisor) = #result"() {
        expect:
        result == this.solution29.divide(dividend, divisor)

        where:
        dividend          | divisor     || result
        1100540749        | -1090366779 || -1
        8                 | 3           || 2
        6                 | 2           || 3
        Integer.MIN_VALUE | -1          || Integer.MAX_VALUE
        Integer.MAX_VALUE | 1           || Integer.MAX_VALUE
    }
}
