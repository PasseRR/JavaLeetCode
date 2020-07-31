package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0807}单元测试
 * @date 2020/07/31 13:17
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0807Spec extends Specification {
    Lcci0807 lcci0807 = new Lcci0807()

    @Unroll
    def "permutation(#s) = #result"() {
        expect:
        result == this.lcci0807.permutation(s)

        where:
        s     || result
        "ab"  || ["ab", "ba"] as String[]
        "qwe" || ["qwe", "qew", "wqe", "weq", "ewq", "eqw"] as String[]
    }
}