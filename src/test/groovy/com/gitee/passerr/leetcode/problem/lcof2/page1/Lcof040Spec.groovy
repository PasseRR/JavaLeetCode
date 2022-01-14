package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof040}单元测试
 * @date 2022/01/14 15:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof040Spec extends Specification {
    Lcof040 lcof040 = new Lcof040()

    @Unroll
    def "maximalRectangle(#matrix) = #result"() {
        expect:
        result == this.lcof040.maximalRectangle(matrix)

        where:
        matrix                                           || result
        ["10100", "10111", "11111", "10010"] as String[] || 6
        [] as String[]                                   || 0
        ["0"] as String[]                                || 0
        ["1"] as String[]                                || 1
    }
}
