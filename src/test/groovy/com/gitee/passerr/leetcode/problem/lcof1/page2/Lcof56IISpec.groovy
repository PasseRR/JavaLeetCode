package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof56II}单元测试
 * @date 2020/07/21 17:09
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof56IISpec extends Specification {
    Lcof56II lcof56II = new Lcof56II()

    @Unroll
    def "singleNumber(#nums) = #result"() {
        expect:
        result == this.lcof56II.singleNumber(nums)

        where:
        nums                           || result
        [3, 4, 3, 3] as int[]          || 4
        [9, 1, 7, 9, 7, 7, 9] as int[] || 1
    }
}