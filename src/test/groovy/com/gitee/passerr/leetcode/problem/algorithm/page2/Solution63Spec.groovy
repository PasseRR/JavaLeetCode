package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution63}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 11:14
 * @author xiehai
 */
class Solution63Spec extends Specification {
    Solution63 solution63 = new Solution63()

    @Unroll
    def "uniquePathsWithObstacles(#obstacleGrid) = #result"() {
        expect:
        result == this.solution63.uniquePathsWithObstacles(obstacleGrid)

        where:
        obstacleGrid || result
        [
            [0, 0, 0],
            [0, 1, 0],
            [0, 0, 0]
        ] as int[][] || 2
        [
            [1, 0, 0],
            [0, 1, 0],
            [0, 0, 0]
        ] as int[][] || 0
    }
}
