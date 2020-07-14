package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof51}单元测试
 * @date 2020/07/14 13:22
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof51Spec extends Specification {
    Lcof51 lcof51 = new Lcof51()

    @Unroll
    def "reversePairs(#nums) = #result"() {
        expect:
        result == this.lcof51.reversePairs(nums)

        where:
        nums                     || result
        [7, 5, 6, 4, 3] as int[] || 9
        [1, 3, 2, 3, 1] as int[] || 4
    }
}