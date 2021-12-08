package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof49}单元测试
 * @date 2020/07/14 13:16
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof49Spec extends Specification {
    Lcof49 lcof49 = new Lcof49()

    @Unroll
    def "nthUglyNumber(#n) = #result"() {
        expect:
        result == this.lcof49.nthUglyNumber(n)

        where:
        n  || result
        1  || 1
        2  || 2
        10 || 12
    }
}