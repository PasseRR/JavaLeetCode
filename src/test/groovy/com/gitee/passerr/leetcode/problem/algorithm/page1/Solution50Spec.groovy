package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution50}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 20:20
 * @author xiehai
 */
class Solution50Spec extends Specification {
    Solution50 solution50 = new Solution50()

    @Unroll
    def "myPow(#x, #n) = #result"() {
        expect:
        result == this.solution50.myPow(x, n)

        where:
        x                 | n  || result
        2.00000 as double | 10 || 1024.00000 as double
        2 as double       | 3  || 8 as double
        2                 | -2 || 0.25 as double
    }
}
