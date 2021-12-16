package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof012}单元测试
 * @date 2021/12/16 11:56
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof012Spec extends Specification {
    Lcof012 lcof012 = new Lcof012()

    @Unroll
    def "pivotIndex(#nums) = #result"() {
        expect:
        result == this.lcof012.pivotIndex(nums)

        where:
        nums                        || result
        [1, 7, 3, 6, 5, 6] as int[] || 3
        [1, 2, 3] as int[]          || -1
        [2, 1, -1] as int[]         || 0
    }
}
