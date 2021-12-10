package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof004}单元测试
 * @date 2021/12/10 17:56
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof004Spec extends Specification {
    Lcof004 lcof004 = new Lcof004()

    @Unroll
    def "singleNumber(#nums) = #result"() {
        expect:
        result == this.lcof004.singleNumber(nums)

        where:
        nums                            || result
        [2, 3, 2, 2] as int[]           || 3
        [0, 1, 0, 1, 0, 1, 99] as int[] || 99
    }
}