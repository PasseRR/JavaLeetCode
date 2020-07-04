package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof29}单元测试
 * @date 2020/07/04 15:58
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof29Spec extends Specification {
    Lcof29 lcof29 = new Lcof29()

    @Unroll
    def "spiralOrder(#matrix) = #result"() {
        expect:
        result == this.lcof29.spiralOrder(matrix)

        where:
        matrix        || result
        [
            [2, 3, 4],
            [5, 6, 7],
            [8, 9, 10],
            [11, 12, 13],
            [14, 15, 16]
        ] as int[][]  || [2, 3, 4, 7, 10, 13, 16, 15, 14, 11, 8, 5, 6, 9, 12] as int[]
        [
            [1, 2],
            [3, 4]
        ] as int[][]  || [1, 2, 4, 3]
        [
            [1], [2], [3],
            [4], [5], [6],
            [7], [8], [9],
            [10]
        ] as int[][]  || [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[]
        [] as int[][] || [] as int[]
        [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ] as int[][]  || [1, 2, 3, 6, 9, 8, 7, 4, 5] as int[]
        [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9, 10, 11, 12]
        ] as int[][]  || [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7] as int[]
        [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9, 10, 11, 12],
            [13, 14, 15, 16]
        ] as int[][]  || [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10] as int[]
        [
            [1, 2, 3, 4, 5],
            [5, 6, 7, 8, 6],
            [9, 10, 11, 12, 7],
            [13, 14, 15, 16, 8]
        ] as int[][]  || [1, 2, 3, 4, 5, 6, 7, 8, 16, 15, 14, 13, 9, 5, 6, 7, 8, 12, 11, 10] as int[]
    }
}