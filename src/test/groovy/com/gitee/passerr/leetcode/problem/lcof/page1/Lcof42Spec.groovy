package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof42}单元测试
 * @date 2020/07/14 13:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof42Spec extends Specification {
    Lcof42 lcof42 = new Lcof42()

    @Unroll
    def "maxSubArray(#nums) = #result"() {
        expect:
        result == this.lcof42.maxSubArray(nums)

        where:
        nums                                     || result
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] || 6
    }
}