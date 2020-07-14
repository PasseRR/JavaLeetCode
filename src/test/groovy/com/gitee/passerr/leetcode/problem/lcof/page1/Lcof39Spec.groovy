package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof39}单元测试
 * @date 2020/07/14 12:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof39Spec extends Specification {
    Lcof39 lcof39 = new Lcof39()

    @Unroll
    def "majorityElement(#nums) = #result"() {
        expect:
        result == this.lcof39.majorityElement(nums)

        where:
        nums                                 || result
        [1, 1, 2] as int[]                   || 1
        [1, 2, 3, 2, 2, 2, 5, 4, 2] as int[] || 2
    }
}