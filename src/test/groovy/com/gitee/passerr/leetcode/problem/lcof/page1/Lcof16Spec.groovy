package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof16}单元测试
 * @date 2020/07/04 14:59
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof16Spec extends Specification {
    Lcof16 lcof16 = new Lcof16()

    @Unroll
    def "myPow(#x, #n) = #result"() {
        expect:
        result == this.lcof16.myPow(x, n)

        where:
        x    | n  || result
        2.0D | 10 || 1024.0D
        2D   | -2 || 0.25D
    }
}