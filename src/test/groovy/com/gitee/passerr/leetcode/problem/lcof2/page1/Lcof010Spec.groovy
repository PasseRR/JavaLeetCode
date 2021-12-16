package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof010}单元测试
 * @date 2021/12/15 18:03
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof010Spec extends Specification {
    Lcof010 lcof010 = new Lcof010()

    @Unroll
    def "subarraySum(#nums, #k) = #result"() {
        expect:
        result == this.lcof010.subarraySum(nums, k)

        where:
        nums               | k || result
        [1, 1, 1] as int[] | 2 || 2
        [1, 2, 3] as int[] | 3 || 2
    }
}
