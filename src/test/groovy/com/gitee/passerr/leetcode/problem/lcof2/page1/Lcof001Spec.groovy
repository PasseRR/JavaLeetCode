package com.gitee.passerr.leetcode.problem.lcof2.page1


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof001}单元测试
 * @date 2021/12/10 14:32
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof001Spec extends Specification {
    Lcof001 lcof001 = new Lcof001()

    @Unroll
    def "divide(#a, #b) = #result"() {
        expect:
        result == this.lcof001.divide(a, b)

        where:
        a                 | b  || result
        15                | 2  || 7
        7                 | -3 || -2
        0                 | 1  || 0
        1                 | 1  || 1
        Integer.MIN_VALUE | -1 || Integer.MAX_VALUE
    }
}