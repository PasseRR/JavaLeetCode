package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof14I}单元测试
 * @date 2020/07/04 14:53
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof14ISpec extends Specification {
    Lcof14I lcof14I = new Lcof14I()

    @Unroll
    def "cuttingRope(#n) = #result"() {
        expect:
        result == this.lcof14I.cuttingRope(n)

        where:
        n  || result
        2  || 1
        10 || 36
    }
}