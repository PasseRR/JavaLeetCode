package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0801}单元测试
 * @date 2020/06/23 09:56
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0801Spec extends Specification {
    Lcci0801 lcci0801 = new Lcci0801()

    @Unroll
    def "waysToStep(#n) = #result"() {
        expect:
        result == this.lcci0801.waysToStep(n)
        where:
        n       || result
        3       || 4
        5       || 13
        1000000 || 746580045
    }
}