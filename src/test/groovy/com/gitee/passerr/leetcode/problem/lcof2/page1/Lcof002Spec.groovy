package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof002}单元测试
 * @date 2021/12/10 15:06
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof002Spec extends Specification {
    Lcof002 lcof002 = new Lcof002()

    @Unroll
    def "addBinary(#a, #b) = #result"() {
        expect:
        result == this.lcof002.addBinary(a, b)

        where:
        a      | b      || result
        "1"     | "1"    || "10"
        "1"    | ""     || "1"
        "0"    | "1"    || "1"
        "11"   | "1"    || "100"
        "1010" | "1011" || "10101"
    }
}
