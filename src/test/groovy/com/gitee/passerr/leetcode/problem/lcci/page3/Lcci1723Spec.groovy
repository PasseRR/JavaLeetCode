package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1723}单元测试
 * @date 2021/06/17 15:19
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1723Spec extends Specification {
    Lcci1723 lcci1723 = new Lcci1723()

    @Unroll
    def "findSquare(#matrix) = #result"() {
        expect:
        result == this.lcci1723.findSquare(matrix)

        where:
        matrix       || result
        [
            [1, 0, 1],
            [0, 0, 1],
            [0, 0, 1]
        ] as int[][] || [1, 0, 2] as int[]
        [
            [0, 1, 1],
            [1, 0, 1],
            [1, 1, 0]
        ] as int[][] || [0, 0, 1] as int[]
        [
            [1, 1, 1, 0, 1, 1, 0, 1, 0, 0],
            [0, 1, 0, 1, 1, 0, 0, 0, 1, 1],
            [0, 0, 1, 1, 0, 0, 1, 1, 1, 0],
            [0, 1, 1, 1, 0, 1, 0, 0, 1, 0],
            [1, 1, 0, 1, 1, 0, 1, 0, 0, 1],
            [0, 1, 1, 0, 0, 0, 0, 1, 1, 0],
            [1, 0, 0, 0, 0, 1, 1, 1, 1, 1],
            [1, 0, 1, 0, 1, 0, 0, 0, 1, 0],
            [1, 1, 1, 1, 0, 1, 0, 1, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 0]
        ] as int[][] || [5, 3, 2] as int[]
        [
            [1, 1, 1, 1, 0, 1, 0, 1, 1, 1],
            [1, 1, 0, 0, 0, 0, 0, 0, 0, 0],
            [1, 1, 1, 1, 0, 1, 0, 1, 0, 1],
            [1, 1, 1, 1, 0, 0, 0, 0, 0, 0],
            [1, 0, 1, 0, 1, 1, 1, 1, 1, 1],
            [1, 1, 0, 0, 1, 0, 1, 0, 0, 1],
            [0, 0, 0, 1, 1, 1, 0, 1, 0, 1],
            [0, 0, 0, 1, 0, 1, 0, 1, 0, 1],
            [1, 0, 1, 0, 1, 1, 0, 1, 1, 1],
            [1, 1, 1, 0, 1, 0, 0, 1, 1, 1]
        ] as int[][] || [1, 4, 3] as int[]
    }
}