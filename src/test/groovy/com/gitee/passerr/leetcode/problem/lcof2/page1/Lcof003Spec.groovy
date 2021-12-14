package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof003}单元测试
 * @date 2021/12/10 16:25
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof003Spec extends Specification {
    Lcof003 lcof003 = new Lcof003()

    @Unroll
    def "countBits(#n) = #result"() {
        expect:
        result == this.lcof003.countBits(n)

        where:
        n  || result
        4  || [0, 1, 1, 2, 1] as int[]
        16 || [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1] as int[]
    }
}
