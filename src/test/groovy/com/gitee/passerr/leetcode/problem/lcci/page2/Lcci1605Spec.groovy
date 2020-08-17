package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1605}单元测试
 * @date 2020/08/17 14:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1605Spec extends Specification {
    Lcci1605 lcci1605 = new Lcci1605()

    @Unroll
    def "trailingZeroes(#n) = #result"() {
        expect:
        result == this.lcci1605.trailingZeroes(n)

        where:
        n  || result
        5  || 1
        10 || 2
        25 || 6
    }
}