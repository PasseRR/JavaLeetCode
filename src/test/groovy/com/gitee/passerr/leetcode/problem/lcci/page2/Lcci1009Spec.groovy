package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1009}单元测试
 * @date 2020/08/10 11:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1009Spec extends Specification {
    Lcci1009 lcci1009 = new Lcci1009()

    @Unroll
    def "searchMatrix(#matrix, #target) = #result"() {
        expect:
        result == this.lcci1009.searchMatrix(matrix, target)

        where:
        matrix                      | target || result
        [
                [1, 4, 7, 11, 15],
                [2, 5, 8, 12, 19],
                [3, 6, 9, 16, 22],
                [10, 13, 14, 17, 24],
                [18, 21, 23, 26, 30]
        ] as int[][]                | 5      || true
        [
                [1, 4, 7, 11, 15],
                [2, 5, 8, 12, 19],
                [3, 6, 9, 16, 22],
                [10, 13, 14, 17, 24],
                [18, 21, 23, 26, 30]
        ] as int[][]                | 20     || false
        [[-5]] as int[][]           | -10    || false
        [[1, 4], [2, 5]] as int[][] | 2      || true
    }
}