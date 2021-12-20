package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof015}单元测试
 * @date 2021/12/17 10:24
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof015Spec extends Specification {
    Lcof015 lcof015 = new Lcof015()

    @Unroll
    def "findAnagrams(#s, #p) = #result"() {
        expect:
        result == this.lcof015.findAnagrams(s, p)

        where:
        s            | p     || result
        "cbaebabacd" | "abc" || [0, 6] as int[]
        "abab"       | "ab"  || [0, 1, 2] as int[]
    }
}
