package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0101}单元测试
 * @date 2020/06/05 14:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0101Spec extends Specification {
    Lcci0101 lcci0101 = new Lcci0101()

    @Unroll
    def "isUnique(#astr) = #result"() {
        expect:
        result == this.lcci0101.isUnique(astr)

        where:
        astr       || result
        "leetcode" || false
        "abc"      || true
    }
}
