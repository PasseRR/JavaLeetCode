package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution44}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 11:28
 * @author xiehai
 */
class Solution44Spec extends Specification {
    Solution44 solution44 = new Solution44()

    @Unroll
    def "isMatch(#s, #p) = #result"() {
        expect:
        result == this.solution44.isMatch(s, p)

        where:
        s                                                     | p                        || result
        "aaa"                                                 | "*a"                    || true
        ""                                                    | "*"                      || true
        ""                                                    | ""                       || true
        "abc"                                                 | ""                       || false
        ""                                                    | "aa"                     || false
        "abc"                                                 | "*"                      || true
        "abc"                                                 | "*?*"                    || true
        "adceb"                                               | "*a*b"                   || true
        "acdcb"                                               | "a*c?b"                  || false
        "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab" | "***bba**a*bbba**aab**b" || false
    }
}
