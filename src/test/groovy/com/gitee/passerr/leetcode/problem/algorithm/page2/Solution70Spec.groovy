package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution70}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 17:21
 * @author xiehai
 */
class Solution70Spec extends Specification {
    Solution70 solution70 = new Solution70()

    @Unroll
    def "climbStairs(#n) = #result"() {
        expect:
        result == this.solution70.climbStairs(n)

        where:
        n  || result
        1  || 1
        2  || 2
        3  || 3
        4  || 5
        5  || 8
        44 || 1134903170
    }
}
