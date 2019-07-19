package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution76}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 10:26
 * @author xiehai
 */
class Solution76Spec extends Specification {
    Solution76 solution76 = new Solution76()

    @Unroll
    def "minWindow(#s, #t) = #result"() {
        expect:
        result == this.solution76.minWindow(s, t)

        where:
        s               | t     || result
        "ADOBECODEBANC" | "ABC" || "BANC"
        "acbbaca"       | "aba" || "baca"
    }
}
