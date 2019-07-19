package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution77}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 12:49
 * @author xiehai
 */
class Solution77Spec extends Specification {
    Solution77 solution77 = new Solution77()

    @Unroll
    def "combine(#n, #k) = #result"() {
        expect:
        result == this.solution77.combine(n, k)

        where:
        n | k || result
        4 | 2 || [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
        3 | 3 || [[1, 2, 3]]
    }
}
