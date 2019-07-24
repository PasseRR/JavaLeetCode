package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution91}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/24 14:36
 * @author xiehai
 */
class Solution91Spec extends Specification {
    Solution91 solution91 = new Solution91()

    @Unroll
    def "numDecodings(#s) = #result"() {
        expect:
        result == this.solution91.numDecodings(s)

        where:
        s       || result
        "230"   || 0
        "110"   || 1
        "100"   || 0
        "00"    || 0
        "00213" || 0
        "10"    || 1
        "0"     || 0
        "1011"  || 2
        "127"   || 2
        "126"   || 3
        "1267"  || 3
        "12"    || 2
        "226"   || 3
        "2226"  || 5
    }
}
