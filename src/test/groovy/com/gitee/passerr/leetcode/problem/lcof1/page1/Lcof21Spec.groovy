package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof21}单元测试
 * @date 2020/07/04 15:39
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof21Spec extends Specification {
    Lcof21 lcof21 = new Lcof21()

    @Unroll
    def "exchange(#nums) = #result"() {
        expect:
        result == this.lcof21.exchange(nums)

        where:
        nums                     || result
        [1, 2, 3, 4, 5] as int[] || [1, 3, 5, 2, 4] as int[]
    }
}