package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution74}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/17 15:29
 * @author xiehai
 */
class Solution74Spec extends Specification {
    Solution74 solution74 = new Solution74()

    @Unroll
    def "searchMatrix(#matrix, #target) = #result"() {
        expect:
        result == this.solution74.searchMatrix(matrix, target)

        where:
        matrix       | target || result
        [
            [1, 3, 5, 7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ] as int[][] | 3      || true
        [
            [1, 3, 5, 7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ] as int[][] | 0      || false
        [
            [1, 3, 5, 7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ] as int[][] | 100    || false
    }
}
