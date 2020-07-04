package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof03}单元测试
 * @date 2020/07/04 13:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof03Spec extends Specification {
    Lcof03 lcof03 = new Lcof03()

    @Unroll
    def "findRepeatNumber(#nums) = #result"() {
        expect:
        result == this.lcof03.findRepeatNumber(nums)

        where:
        nums                           || result
        [2, 3, 1, 0, 2, 5, 3] as int[] || 2
    }
}