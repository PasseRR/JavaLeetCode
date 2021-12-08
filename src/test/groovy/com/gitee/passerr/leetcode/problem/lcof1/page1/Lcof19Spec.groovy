package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof19}单元测试
 * @date 2020/07/04 15:08
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof19Spec extends Specification {
    Lcof19 lcof19 = new Lcof19()

    @Unroll
    def "isMatch(#s, #p) == #result"() {
        expect:
        result == this.lcof19.isMatch(s, p)

        where:
        s    | p    || result
        "aa" | "a"  || false
        "ab" | ".*" || true
        ""   | ".*" || true
    }
}