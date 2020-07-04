package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof10II}单元测试
 * @date 2020/07/04 14:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof10IISpec extends Specification {
    Lcof10II lcof10II = new Lcof10II()

    @Unroll
    def "numWays(#n) = #result"() {
        expect:
        result == this.lcof10II.numWays(n)

        where:
        n || result
        2 || 2
        7 || 21
    }
}