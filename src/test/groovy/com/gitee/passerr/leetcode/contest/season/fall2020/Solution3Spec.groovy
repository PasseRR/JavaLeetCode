package com.gitee.passerr.leetcode.contest.season.fall2020

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution3}单元测试
 * @date 2020/09/12 15:49
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution3Spec extends Specification {
    Solution3 solution3 = new Solution3()

    @Unroll
    def "minimumOperations(#leaves) = #result"() {
        expect:
        result == this.solution3.minimumOperations(leaves)

        where:
        leaves          || result
        "rrryyyrryyyrr" || 0
        "ryr"           || 0
    }
}