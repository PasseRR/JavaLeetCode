package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof017}单元测试
 * @date 2021/12/17 17:19
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof017Spec extends Specification {
    Lcof017 lcof017 = new Lcof017()

    @Unroll
    def "minWindow(#s, #t) = #result"() {
        expect:
        result == this.lcof017.minWindow(s, t)

        where:
        s                   | t     || result
        "cabwefgewcwaefgcf" | "cae" || "cwae"
    }
}
