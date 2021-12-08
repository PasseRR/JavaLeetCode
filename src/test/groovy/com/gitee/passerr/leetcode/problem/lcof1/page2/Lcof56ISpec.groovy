package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof56I}单元测试
 * @date 2020/07/21 17:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof56ISpec extends Specification {
    Lcof56I lcof56I = new Lcof56I()

    @Unroll
    def "singleNumbers(#nums) = #result"() {
        expect:
        result == this.lcof56I.singleNumbers(nums)

        where:
        nums                               || result
        [4, 1, 4, 6] as int[]              || [6, 1] as int[]
        [1, 2, 10, 4, 1, 4, 3, 3] as int[] || [2, 10] as int[]
    }
}