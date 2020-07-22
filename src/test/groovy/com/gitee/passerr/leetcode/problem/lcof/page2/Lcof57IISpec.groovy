package com.gitee.passerr.leetcode.problem.lcof.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof57II}单元测试
 * @date 2020/07/21 17:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof57IISpec extends Specification {
    Lcof57II lcof57II = new Lcof57II()

    @Unroll
    def "findContinuousSequence(#target) = #result"() {
        expect:
        result == this.lcof57II.findContinuousSequence(target)

        where:
        target || result
        9      || [[2, 3, 4], [4, 5]] as int[][]
        15     || [[1, 2, 3, 4, 5], [4, 5, 6], [7, 8]] as int[][]
    }
}