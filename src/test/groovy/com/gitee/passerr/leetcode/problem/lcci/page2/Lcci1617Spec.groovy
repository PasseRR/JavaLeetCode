package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1617}单元测试
 * @date 2020/09/01 17:36
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1617Spec extends Specification {
    Lcci1617 lcci1617 = new Lcci1617()

    @Unroll
    def "maxSubArray(#nums) = #result"() {
        expect:
        result == this.lcci1617.maxSubArray(nums)

        where:
        nums                                     || result
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] || 6
    }
}