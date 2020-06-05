package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0108}单元测试
 * @date 2020/06/05 16:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0108Spec extends Specification {
    Lcci0108 lcci0108 = new Lcci0108()

    @Unroll
    def "setZeroes(#matrix) = #result"() {
        when:
        this.lcci0108.setZeroes(matrix)
        then:
        matrix.length.times { it ->
            assert Arrays.toString(matrix[it]) == Arrays.toString(result[it])
        }

        where:
        matrix       || result
        [
            [1, 1, 1],
            [1, 0, 1],
            [1, 1, 1]
        ] as int[][] || [
            [1, 0, 1],
            [0, 0, 0],
            [1, 0, 1]
        ] as int[][]
        [
            [0, 1, 2, 0],
            [3, 4, 5, 2],
            [1, 3, 1, 5]
        ] as int[][] || [
            [0, 0, 0, 0],
            [0, 4, 5, 0],
            [0, 3, 1, 0]
        ] as int[][]
    }
}