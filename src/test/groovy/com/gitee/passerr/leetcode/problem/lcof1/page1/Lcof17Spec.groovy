package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof17}单元测试
 * @date 2020/07/04 15:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof17Spec extends Specification {
    Lcof17 lcof17 = new Lcof17()

    @Unroll
    def "printNumbers(#n) == #result"() {
        expect:
        result == this.lcof17.printNumbers(n)

        where:
        n || result
        1 || 1..9 as int[]
        2 || 1..99 as int[]
        3 || 1..999 as int[]
    }
}