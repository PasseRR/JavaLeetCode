package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof007}单元测试
 * @date 2021/12/13 11:59
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof007Spec extends Specification {
    Lcof007 lcof007 = new Lcof007()

    @Unroll
    def "threeSum(#nums) = #result"() {
        expect:
        result == this.lcof007.threeSum(nums)

        where:
        nums                           || result
        [-1, 0, 1, 2, -1, -4] as int[] || [[-1, -1, 2], [-1, 0, 1]]
    }
}