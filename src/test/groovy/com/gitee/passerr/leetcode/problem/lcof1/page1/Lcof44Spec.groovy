package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof44}单元测试
 * @date 2020/07/14 13:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof44Spec extends Specification {
    Lcof44 lcof44 = new Lcof44()

    @Unroll
    def "findNthDigit(#n) == #result"() {
        expect:
        result == this.lcof44.findNthDigit(n)

        where:
        n  || result
        3  || 3
        11 || 0
    }
}