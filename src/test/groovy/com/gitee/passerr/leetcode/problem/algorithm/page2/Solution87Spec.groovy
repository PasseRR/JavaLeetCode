package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution87}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 09:55
 * @author xiehai
 */
class Solution87Spec extends Specification {
    Solution87 solution87 = new Solution87()

    @Unroll
    def "isScramble(#s1, #s2) = #result"() {
        expect:
        result == this.solution87.isScramble(s1, s2)

        where:
        s1      | s2      || result
        "great" | "rgtae" || true
        "abcde" | "caebd" || false
    }
}
