package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof008}单元测试
 * @date 2021/12/13 14:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof008Spec extends Specification {
    Lcof008 lcof008 = new Lcof008()

    @Unroll
    def "minSubArrayLen(#target, #nums) = #result"() {
        expect:
        result == this.lcof008.minSubArrayLen(target, nums)

        where:
        target | nums                              || result
        7      | [2, 3, 1, 2, 4, 3] as int[]       || 2
        4      | [1, 4, 4] as int[]                || 1
        11     | [1, 1, 1, 1, 1, 1, 1, 1] as int[] || 0
        11     | [1, 2, 3, 4, 5] as int[]          || 3
    }
}
