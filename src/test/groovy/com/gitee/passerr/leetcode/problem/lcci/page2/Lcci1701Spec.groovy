package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1701}单元测试
 * @date 2020/08/25 17:29
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1701Spec extends Specification {
    Lcci1701 lcci1701 = new Lcci1701()

    @Unroll
    def "add(#a, #b) = #result"() {
        expect:
        result == this.lcci1701.add(a, b)

        where:
        a | b || result
        1 | 3 || 4
    }
}