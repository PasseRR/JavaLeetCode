package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof67}单元测试
 * @date 2020/07/22 09:34
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof67Spec extends Specification {
    Lcof67 lcof67 = new Lcof67()

    @Unroll
    def "strToInt(#str) = #result"() {
        expect:
        result == this.lcof67.strToInt(str)

        where:
        str            || result
        "   -42"       || -42
        "abc"          || 0
        "-91283472332" || Integer.MIN_VALUE
    }
}