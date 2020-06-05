package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution122}单元测试
 * @date 2020/06/05 17:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution122Spec extends Specification {
    Solution122 solution122 = new Solution122()

    @Unroll
    def "maxProfit(#prices) = #result"() {
        expect:
        result == this.solution122.maxProfit(prices)

        where:
        prices                      || result
        [7, 1, 5, 3, 6, 4] as int[] || 7
        [1, 2, 3, 4, 5] as int[]    || 4
        [7, 6, 4, 3, 1] as int[]    || 0
    }
}