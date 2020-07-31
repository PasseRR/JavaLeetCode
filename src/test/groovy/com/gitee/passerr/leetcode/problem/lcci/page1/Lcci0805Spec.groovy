package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0805}单元测试
 * @date 2020/07/31 13:13
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0805Spec extends Specification {
    Lcci0805 lcci0805 = new Lcci0805()

    @Unroll
    def "multiply(#a, #b) = #result"() {
        expect:
        result == this.lcci0805.multiply(a, b)

        where:
        a   | b || result
        2   | 3 || 6
        100 | 2 || 200
    }
}