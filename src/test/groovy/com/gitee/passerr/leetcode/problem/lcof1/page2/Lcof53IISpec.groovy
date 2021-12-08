package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof53II}单元测试
 * @date 2020/07/14 16:21
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof53IISpec extends Specification {
    Lcof53II lcof53II = new Lcof53II()

    @Unroll
    def "missingNumber(#nums) = #result"() {
        expect:
        result == this.lcof53II.missingNumber(nums)

        where:
        nums                                 || result
        [1, 2, 3] as int[]                   || 0
        [0, 1, 3, 4] as int[]                || 2
        [0, 1, 2, 3, 4, 5, 6, 7, 9] as int[] || 8
    }
}