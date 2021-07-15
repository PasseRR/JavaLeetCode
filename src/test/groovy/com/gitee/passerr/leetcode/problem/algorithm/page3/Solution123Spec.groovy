package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution123}单元测试
 * @date 2021/07/15 14:00
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution123Spec extends Specification {
    Solution123 solution123 = new Solution123()

    @Unroll
    def "maxProfit(#prices) = #result"() {
        expect:
        result == this.solution123.maxProfit(prices)

        where:
        prices                                           || result
        [8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6] as int[] || 11
        [2, 1, 2, 0, 1] as int[]                         || 2
        [3, 3, 5, 0, 0, 3, 1, 4] as int[]                || 6
    }
}