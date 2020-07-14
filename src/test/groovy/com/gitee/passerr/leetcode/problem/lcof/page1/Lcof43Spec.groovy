package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof43}单元测试
 * @date 2020/07/14 13:03
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof43Spec extends Specification {
    Lcof43 lcof43 = new Lcof43()

    @Unroll
    def "countDigitOne(#n) = #result"() {
        expect:
        result == this.lcof43.countDigitOne(n)

        where:
        n  || result
        12 || 5
        13 || 6
    }
}