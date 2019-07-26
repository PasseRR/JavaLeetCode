package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution118}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 11:20
 * @author xiehai
 */
class Solution118Spec extends Specification {
    Solution118 solution118 = new Solution118()

    @Unroll
    def "generate(#n) = #result"() {
        expect:
        result == this.solution118.generate(n)

        where:
        n || result
        0 || []
        1 || [[1]]
        2 || [[1], [1, 1]]
        3 || [[1], [1, 1], [1, 2, 1]]
        4 || [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
        5 || [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
