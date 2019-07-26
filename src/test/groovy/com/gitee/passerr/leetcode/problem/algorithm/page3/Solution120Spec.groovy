package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution120}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 13:38
 * @author xiehai
 */
class Solution120Spec extends Specification {
    Solution120 solution120 = new Solution120()

    @Unroll
    def "minimumTotal(#triangle) = #result"() {
        expect:
        result == this.solution120.minimumTotal(triangle)

        where:
        triangle || result
        [
            [2],
            [3, 4],
            [6, 5, 7],
            [4, 1, 8, 3]
        ]        || 11
    }
}
