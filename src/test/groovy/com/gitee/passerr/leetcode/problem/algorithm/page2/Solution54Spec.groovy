package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution54}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/12 13:35
 * @author xiehai
 */
class Solution54Spec extends Specification {
    Solution54 solution54 = new Solution54()

    @Unroll
    def "spiralOrder(#matrix) = #result"() {
        expect:
        result == this.solution54.spiralOrder(matrix)

        where:
        matrix        || result
        [
            [2, 3, 4],
            [5, 6, 7],
            [8, 9, 10],
            [11, 12, 13],
            [14, 15, 16]
        ] as int[][]  || [2, 3, 4, 7, 10, 13, 16, 15, 14, 11, 8, 5, 6, 9, 12]
        [
            [1, 2],
            [3, 4]
        ] as int[][]  || [1, 2, 4, 3]
        [
            [1], [2], [3],
            [4], [5], [6],
            [7], [8], [9],
            [10]
        ] as int[][]  || [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        [] as int[][] || []
        [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ] as int[][]  || [1, 2, 3, 6, 9, 8, 7, 4, 5]
        [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9, 10, 11, 12]
        ] as int[][]  || [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9, 10, 11, 12],
            [13, 14, 15, 16]
        ] as int[][]  || [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        [
            [1, 2, 3, 4, 5],
            [5, 6, 7, 8, 6],
            [9, 10, 11, 12, 7],
            [13, 14, 15, 16, 8]
        ] as int[][]  || [1, 2, 3, 4, 5, 6, 7, 8, 16, 15, 14, 13, 9, 5, 6, 7, 8, 12, 11, 10]
    }
}
