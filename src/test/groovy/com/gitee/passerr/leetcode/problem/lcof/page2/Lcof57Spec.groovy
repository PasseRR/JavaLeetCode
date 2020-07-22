package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof57}单元测试
 * @date 2020/07/21 17:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof57Spec extends Specification {
    Lcof57 lcof57 = new Lcof57()

    @Unroll
    def "twoSum(#nums, #target) = #result"() {
        expect:
        result == this.lcof57.twoSum(nums, target)

        where:
        nums                              | target || result
        [2, 7, 11, 15] as int[]           | 9      || [2, 7] as int[]
        [10, 26, 30, 31, 47, 60] as int[] | 40     || [10, 30] as int[]
    }
}