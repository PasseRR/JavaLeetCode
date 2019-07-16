package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution62}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 10:32
 * @author xiehai
 */
class Solution62Spec extends Specification {
    Solution62 solution62 = new Solution62()

    @Unroll
    def "uniquePaths(#m, #n) = #result"() {
        expect:
        result == this.solution62.uniquePaths(m, n)

        where:
        m | n || result
        3 | 2 || 3
        7 | 3 || 28
    }
}
