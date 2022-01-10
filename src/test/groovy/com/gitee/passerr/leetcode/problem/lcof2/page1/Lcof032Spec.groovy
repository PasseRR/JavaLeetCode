package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof032}单元测试
 * @date 2022/01/10 10:24
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof032Spec extends Specification {
    Lcof032 lcof032 = new Lcof032()

    @Unroll
    def "isAnagram(#s, #t) = #result"() {
        expect:
        result == this.lcof032.isAnagram(s, t)

        where:
        s         | t         || result
        "anagram" | "nagaram" || true
        "a"       | "a"       || false
        "ab"      | "a"       || false
    }
}
