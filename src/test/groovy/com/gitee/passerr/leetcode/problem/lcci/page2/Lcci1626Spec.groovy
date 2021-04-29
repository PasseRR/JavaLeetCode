package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1626}单元测试
 * @date 2021/04/19 13:49
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1626Spec extends Specification {
    Lcci1626 lcci1626 = new Lcci1626()

    @Unroll
    def "calculate(#s) = #result"() {
        expect:
        result == this.lcci1626.calculate(s)

        where:
        s                   || result
        "42"                || 42
        "31+21*2"           || 42 + 31
        "  3/2  "           || 1
        "3 + 5 / 2"         || 5
        "3 + 5 / 2 + 1 - 2" || 4
    }
}