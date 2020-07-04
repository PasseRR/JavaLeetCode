package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof15}单元测试
 * @date 2020/07/04 14:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof15Spec extends Specification {
    Lcof15 lcof15 = new Lcof15()

    @Unroll
    def "hammingWeight(#n) = #result"() {
        expect:
        result == this.lcof15.hammingWeight(n)

        where:
        n  || result
        11 || 3
        -1 || 32
        1  || 1
    }
}