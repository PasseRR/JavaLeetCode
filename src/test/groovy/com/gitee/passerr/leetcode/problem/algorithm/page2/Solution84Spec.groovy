package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution84}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/22 13:30
 * @author xiehai
 */
class Solution84Spec extends Specification {
    Solution84 solution84 = new Solution84()

    @Unroll
    def "largestRectangleArea(#heights) = #result"() {
        expect:
        result == this.solution84.largestRectangleArea(heights)

        where:
        heights                                       || result
        [2, 1, 5, 6, 2, 3] as int[]                   || 10
        [0, 0, 0, 0, 0, 0, 0, 0, 2147483647] as int[] || Integer.MAX_VALUE
    }
}
