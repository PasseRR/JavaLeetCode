package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof61}单元测试
 * @date 2020/07/22 09:20
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof61Spec extends Specification {
    Lcof61 lcof61 = new Lcof61()

    @Unroll
    def "isStraight(#nums) = #result"() {
        expect:
        result == this.lcof61.isStraight(nums)

        where:
        nums                     || result
        [1, 1, 2, 3, 4] as int[] || false
        [1, 0, 3, 0, 5] as int[] || true
    }
}