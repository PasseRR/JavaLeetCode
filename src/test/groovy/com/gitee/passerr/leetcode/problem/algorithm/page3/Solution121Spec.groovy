package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution121}单元测试
 * @date 2020/06/05 17:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution121Spec extends Specification {
    Solution121 solution121 = new Solution121()

    @Unroll
    def "maxProfit(#prices) = #result"() {
        expect:
        result == this.solution121.maxProfit(prices)

        where:
        prices                      || result
        [7, 1, 5, 3, 6, 4] as int[] || 5
        [7, 6, 4, 3, 1] as int[]    || 0
    }
}