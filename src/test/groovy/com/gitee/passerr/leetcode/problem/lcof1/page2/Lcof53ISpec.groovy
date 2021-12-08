package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof53I}单元测试
 * @date 2020/07/14 16:19
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof53ISpec extends Specification {
    Lcof53I lcof53I = new Lcof53I()

    @Unroll
    def "search(#nums, #target) = #result"() {
        expect:
        result == this.lcof53I.search(nums, target)

        where:
        nums                         | target || result
        [5, 7, 7, 8, 8, 10] as int[] | 8      || 2
        [5, 7, 7, 8, 8, 10] as int[] | 6      || 0
    }
}