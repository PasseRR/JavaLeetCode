package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof65}单元测试
 * @date 2020/07/22 09:29
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof65Spec extends Specification {
    Lcof65 lcof65 = new Lcof65()

    @Unroll
    def "add(#a, #b) = #result"() {
        expect:
        result == this.lcof65.add(a, b)

        where:
        a  | b || result
        1  | 2 || 3
        -1 | 1 || 0
    }
}