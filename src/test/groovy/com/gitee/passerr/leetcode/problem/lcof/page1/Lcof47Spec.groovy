package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof47}单元测试
 * @date 2020/07/14 13:12
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof47Spec extends Specification {
    Lcof47 lcof47 = new Lcof47()

    @Unroll
    def "maxValue(#grid) = #result"() {
        expect:
        result == this.lcof47.maxValue(grid)

        where:
        grid                                         || result
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] as int[][] || 12
    }
}