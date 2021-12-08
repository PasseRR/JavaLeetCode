package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof45}单元测试
 * @date 2020/07/14 13:07
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof45Spec extends Specification {
    Lcof45 lcof45 = new Lcof45()

    @Unroll
    def "minNumber(#nums) = #result"() {
        expect:
        result == this.lcof45.minNumber(nums)

        where:
        nums                       || result
        [10, 2] as int[]           || "102"
        [3, 30, 34, 5, 9] as int[] || "3033459"
    }
}