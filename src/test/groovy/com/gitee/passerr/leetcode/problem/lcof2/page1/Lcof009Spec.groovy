package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof009}单元测试
 * @date 2021/12/14 15:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof009Spec extends Specification {
    Lcof009 lcof009 = new Lcof009()

    @Unroll
    def "numSubarrayProductLessThanK(#nums, #k) = #result"() {
        expect:
        result == this.lcof009.numSubarrayProductLessThanK(nums, k)

        where:
        nums                   | k   || result
        [10, 5, 2, 6] as int[] | 100 || 8
        [1, 2, 3] as int[]     | 0   || 0
    }
}
