package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution10}測試用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 11:32
 * @author xiehai
 */
class Solution10Spec extends Specification {
    Solution10 solution10 = new Solution10()

    @Unroll
    def "isMatch(#s, #p) = #result"() {
        expect:
        result == this.solution10.isMatch(s, p)

        where:
        s                | p                       || result
        "aa"             | "a"                     || false
        "aa"             | "a*"                    || true
        "ab"             | ".*"                    || true
        "aab"            | "c*a*b"                 || true
        "aaa"            | "a*a"                   || true
        "ab"             | ".*c"                   || false
        "aaab"           | "a*.ab"                 || true
        "bbba"           | ".*a*a"                 || true
        "aaaaaaaaaaaaab" | "a*a*a*a*a*a*a*a*a*a*c" || false
    }
}
