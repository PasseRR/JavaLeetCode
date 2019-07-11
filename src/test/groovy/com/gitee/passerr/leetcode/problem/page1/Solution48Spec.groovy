package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution48}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/11 10:49
 * @author xiehai
 */
class Solution48Spec extends Specification {
    Solution48 solution48 = new Solution48()

    @Unroll
    def "rotate(#input) = #result"() {
        when:
        this.solution48.rotate(input)
        then:
        input.length.times { it -> assert Arrays.toString(input[it]) == Arrays.toString(result[it]) }

        where:
        input        || result
        [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ] as int[][] || [
            [7, 4, 1],
            [8, 5, 2],
            [9, 6, 3]
        ] as int[][]
        [
            [5, 1, 9, 11],
            [2, 4, 8, 10],
            [13, 3, 6, 7],
            [15, 14, 12, 16]
        ] as int[][] || [
            [15, 13, 2, 5],
            [14, 3, 4, 1],
            [12, 6, 8, 9],
            [16, 7, 10, 11]
        ] as int[][]
    }
}
