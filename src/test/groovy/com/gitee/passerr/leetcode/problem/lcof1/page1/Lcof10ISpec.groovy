package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof10I}单元测试
 * @date 2020/07/04 14:39
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof10ISpec extends Specification {
    Lcof10I lcof10I = new Lcof10I()

    @Unroll
    def "fib(#n) == #result"() {
        expect:
        result == this.lcof10I.fib(n)

        where:
        n || result
        2 || 1
        5 || 5
    }
}