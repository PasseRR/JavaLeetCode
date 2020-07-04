package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof14II}单元测试
 * @date 2020/07/04 14:56
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof14IISpec extends Specification {
    Lcof14II lcof14II = new Lcof14II()

    @Unroll
    def "cuttingRope(#n) = #result"() {
        expect:
        result == this.lcof14II.cuttingRope(n)

        where:
        n  || result
        2  || 1
        10 || 36
    }
}