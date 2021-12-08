package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof04}单元测试
 * @date 2020/07/04 13:57
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof04Spec extends Specification {
    Lcof04 lcof04 = new Lcof04()

    @Unroll
    def "findNumberIn2DArray(#matrix, #target) = #result"() {
        expect:
        result == this.lcof04.findNumberIn2DArray(matrix, target)

        where:
        matrix       | target || result
        [
            [1, 4, 7, 11, 15],
            [2, 5, 8, 12, 19],
            [3, 6, 9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
        ] as int[][] | 5      || true
        [
            [1, 4, 7, 11, 15],
            [2, 5, 8, 12, 19],
            [3, 6, 9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
        ] as int[][] | 20     || false
    }
}