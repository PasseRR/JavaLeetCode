package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof20}单元测试
 * @date 2020/07/04 15:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof20Spec extends Specification {
    Lcof20 lcof20 = new Lcof20()

    @Unroll
    def "isNumber(#s) = #result"() {
        expect:
        result == this.lcof20.isNumber(s)

        where:
        s          || result
        "1.2"      || true
        "1..3"     || false
        ".3"       || true
        "+.3"      || true
        "-.3"      || true
        "-.3e-20"  || true
        "-.3e-2.0" || false
    }
}