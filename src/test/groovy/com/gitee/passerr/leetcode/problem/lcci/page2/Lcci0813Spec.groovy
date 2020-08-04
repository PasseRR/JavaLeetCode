package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0813}单元测试
 * @date 2020/07/31 17:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0813Spec extends Specification {
    Lcci0813 lcci0813 = new Lcci0813()

    @Unroll
    def "pileBox(#box) = #result"() {
        expect:
        result == this.lcci0813.pileBox(box)

        where:
        box                                                     || result
        [[1, 1, 1], [2, 2, 2], [3, 3, 3]] as int[][]            || 6
        [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]] as int[][] || 10
    }
}