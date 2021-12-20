package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof018}单元测试
 * @date 2021/12/20 15:39
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof018Spec extends Specification {
    Lcof018 lcof018 = new Lcof018()

    @Unroll
    def "isPalindrome(#s) = #result"() {
        expect:
        result == this.lcof018.isPalindrome(s)

        where:
        s                                || result
        ",,,,"                           || true
        "A man, a plan, a canal: Panama" || true
        "race a car"                     || false
        ""                               || true
        "0P"                             || false
    }
} 
