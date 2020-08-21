package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1610}单元测试
 * @date 2020/08/21 11:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1610Spec extends Specification {
    Lcci1610 lcci1610 = new Lcci1610()

    @Unroll
    def "maxAliveYear(#birth, #death) = #result"() {
        expect:
        result == this.lcci1610.maxAliveYear(birth, death)

        where:
        birth                       | death                       || result
        [1900, 1950, 1901] as int[] | [1948, 2000, 1951] as int[] || 1901
    }
}