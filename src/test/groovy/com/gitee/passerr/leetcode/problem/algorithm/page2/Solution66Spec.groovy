package com.gitee.passerr.leetcode.problem.algorithm.page2


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution66}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 13:24
 * @author xiehai
 */
class Solution66Spec extends Specification {
    Solution66 solution66 = new Solution66()

    @Unroll
    def "plusOne(#digits) = #result"() {
        expect:
        result == this.solution66.plusOne(digits)

        where:
        digits             || result
        [0] as int[]       || [1] as int[]
        [9] as int[]       || [1, 0] as int[]
        [1, 2, 3] as int[] || [1, 2, 4] as int[]
    }
}
