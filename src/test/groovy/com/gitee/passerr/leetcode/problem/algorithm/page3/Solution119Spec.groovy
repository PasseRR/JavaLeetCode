package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution119}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 11:50
 * @author xiehai
 */
class Solution119Spec extends Specification {
    Solution119 solution119 = new Solution119()

    @Unroll
    def "getRow(#n) = #result"() {
        expect:
        result == this.solution119.getRow(n)

        where:
        n || result
        0 || [1]
        1 || [1, 1]
        2 || [1, 2, 1]
        3 || [1, 3, 3, 1]
        4 || [1, 4, 6, 4, 1]
        5 || [1, 5, 10, 10, 5, 1]
    }
}
