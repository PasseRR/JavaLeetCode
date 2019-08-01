package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution137}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/01 11:11
 * @author xiehai
 */
class Solution137Spec extends Specification {
    Solution137 solution137 = new Solution137()

    @Unroll
    def "singleNumber(#nums) = #result"() {
        expect:
        result == this.solution137.singleNumber(nums)

        where:
        nums                            || result
        [2, 3, 2, 2] as int[]           || 3
        [0, 1, 0, 1, 0, 1, 99] as int[] || 99
    }
}
