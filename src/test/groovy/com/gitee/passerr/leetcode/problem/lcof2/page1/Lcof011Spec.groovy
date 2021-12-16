package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof011}单元测试
 * @date 2021/12/16 10:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof011Spec extends Specification {
    Lcof011 lcof011 = new Lcof011()

    @Unroll
    def "findMaxLength(#nums) = #result"() {
        expect:
        result == this.lcof011.findMaxLength(nums)

        where:
        nums                              || result
        [0, 1, 1] as int[]                || 2
        [0, 1, 0] as int[]                || 2
        [0, 1, 0, 1] as int[]             || 4
        [0, 0, 1, 0, 0, 0, 1, 1] as int[] || 6
    }
}
