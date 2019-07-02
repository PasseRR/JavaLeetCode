package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution11}測試用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 14:25
 * @author xiehai
 */
class Solution11Spec extends Specification {
    Solution11 solution11 = new Solution11()

    @Unroll
    def "maxArea(#input) = #result"() {
        expect:
        result == this.solution11.maxArea(input)

        where:
        input                                || result
        [1, 8, 6, 2, 5, 4, 8, 3, 7] as int[] || 49
        [1, 2, 3] as int[]                   || 2
    }
}
