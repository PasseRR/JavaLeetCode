package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof020}单元测试
 * @date 2021/12/21 11:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof020Spec extends Specification {
    Lcof020 lcof020 = new Lcof020()

    @Unroll
    def "countSubstrings(#s) = #result"() {
        expect:
        result == this.lcof020.countSubstrings(s)

        where:
        s     || result
        "abc" || 3
        "aaa" || 6
    }
}
