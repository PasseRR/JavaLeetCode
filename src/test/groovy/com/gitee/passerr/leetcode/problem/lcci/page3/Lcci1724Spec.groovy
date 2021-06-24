package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1724}单元测试
 * @date 2021/06/21 17:14
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1724Spec extends Specification {
    Lcci1724 lcci1724 = new Lcci1724()

    @Unroll
    def "getMaxMatrix(#matrix) = #result"() {
        expect:
        result == this.lcci1724.getMaxMatrix(matrix)

        where:
        matrix                        || result
        [[-4, -5]] as int[][]         || [0, 0, 0, 0] as int[]
        [[-1, 0], [0, -1]] as int[][] || [1, 0, 1, 0] as int[]
    }
}