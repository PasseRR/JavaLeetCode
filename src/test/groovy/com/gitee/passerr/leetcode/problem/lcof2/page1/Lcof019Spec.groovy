package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof019}单元测试
 * @date 2021/12/20 17:35
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof019Spec extends Specification {
    Lcof019 lcof019 = new Lcof019()

    @Unroll
    def "validPalindrome(#s) = #result"() {
        expect:
        result == this.lcof019.validPalindrome(s)

        where:
        s      || result
        "aba"  || true
        "abca" || true
        "abc"  || false
    }
}
