package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution73}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/17 14:51
 * @author xiehai
 */
class Solution73Spec extends Specification {
    Solution73 solution73 = new Solution73()

    @Unroll
    def "setZeroes(#matrix) = #result"() {
        when:
        this.solution73.setZeroes(matrix)
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
