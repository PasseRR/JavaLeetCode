package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof63}单元测试
 * @date 2020/07/22 09:25
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof63Spec extends Specification {
    Lcof63 lcof63 = new Lcof63()

    @Unroll
    def "maxProfit(#prices) = #result"() {
        expect:
        result == this.lcof63.maxProfit(prices)

        where:
        prices                      || result
        [7, 1, 5, 3, 6, 4] as int[] || 5
        [7, 6, 5, 4, 3, 1] as int[] || 0
    }
}