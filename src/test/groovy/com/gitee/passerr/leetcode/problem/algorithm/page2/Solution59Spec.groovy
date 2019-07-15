package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution59}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/15 13:35
 * @author xiehai
 */
class Solution59Spec extends Specification {
    Solution59 solution59 = new Solution59()

    @Unroll
    def "generateMatrix(#n) = #result"() {
        when:
        def matrix = this.solution59.generateMatrix(n)
        then:
        matrix.length.times { it ->
            assert Arrays.toString(matrix[it]) == Arrays.toString(result[it])
        }

        where:
        n || result
        1 || [[1]] as int[][]
        2 || [[1, 2], [4, 3]] as int[][]
        3 || [[1, 2, 3], [8, 9, 4], [7, 6, 5]] as int[][]
    }
}
