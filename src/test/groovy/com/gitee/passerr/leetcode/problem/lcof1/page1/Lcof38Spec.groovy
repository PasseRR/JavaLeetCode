package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof38}单元测试
 * @date 2020/07/14 12:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof38Spec extends Specification {
    Lcof38 lcof38 = new Lcof38()

    @Unroll
    def "permutation(#s) = #result"() {
        expect:
        result == this.lcof38.permutation(s)

        where:
        s     || result
        "ab"  || ["ab", "ba"] as String[]
        "abc" || ["acb", "bca", "abc", "cba", "bac", "cab"] as String[]
    }
}