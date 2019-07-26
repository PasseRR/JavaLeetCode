package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution136}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 11:09
 * @author xiehai
 */
class Solution136Spec extends Specification {
    Solution136 solution136 = new Solution136()

    @Unroll
    def "singleNumber(#nums) = #result"() {
        expect:
        result == this.solution136.singleNumber(nums)

        where:
        nums                     || result
        [2, 2, 1] as int[]       || 1
        [4, 1, 2, 1, 2] as int[] || 4
    }
}
