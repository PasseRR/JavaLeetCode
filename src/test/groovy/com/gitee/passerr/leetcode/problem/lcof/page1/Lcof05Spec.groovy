package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof05}单元测试
 * @date 2020/07/04 14:27
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof05Spec extends Specification {
    Lcof05 lcof05 = new Lcof05()

    @Unroll
    def "replaceSpace(#s) = #result"() {
        expect:
        result == this.lcof05.replaceSpace(s)

        where:
        s               || result
        "We are happy." || "We%20are%20happy."
    }
}