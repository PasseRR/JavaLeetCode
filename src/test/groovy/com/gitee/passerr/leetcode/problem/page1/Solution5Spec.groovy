package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution5}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 11:32
 * @author xiehai
 */
class Solution5Spec extends Specification {
    Solution5 solution5 = new Solution5()

    @Unroll
    def "longestPalindrome(#input) = #result"() {
        expect:
        result == this.solution5.longestPalindrome(input)

        where:
        input   || result
        "babad" || "bab"
        "cbbd"  || "bb"
        ""      || ""
    }
}
