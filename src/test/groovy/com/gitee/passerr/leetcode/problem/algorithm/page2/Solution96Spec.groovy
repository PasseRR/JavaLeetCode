package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution96}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 10:23
 * @author xiehai
 */
class Solution96Spec extends Specification {
    Solution96 solution96 = new Solution96()

    @Unroll
    def "numTrees(#n) = #result"() {
        expect:
        result == this.solution96.numTrees(n)

        where:
        n || result
        0 || 1
        1 || 1
        2 || 2
        3 || 5
        4 || 14
    }
}
