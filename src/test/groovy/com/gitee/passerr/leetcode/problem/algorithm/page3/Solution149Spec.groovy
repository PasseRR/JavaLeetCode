package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution149}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 15:23
 * @author xiehai
 */
class Solution149Spec extends Specification {
    Solution149 solution149 = new Solution149()

    @Unroll
    def "maxPoints(#points) = #result"() {
        expect:
        result == this.solution149.maxPoints(points)

        where:
        points                                                                                               || result
        [[1, 1], [1, 1], [1, 1]] as int[][]                                                                  || 3
        [[1, 1], [1, 1], [1, 1], [1, 2], [1, 1]] as int[][]                                                  || 5
        [[84, 250], [0, 0], [1, 0], [0, -70], [0, -70], [1, -1], [21, 10], [42, 90], [-42, -230]] as int[][] || 6
        [[0, 0], [1, 65536], [65536, 0]] as int[][]                                                          || 2
        [[1, 1], [2, 2], [3, 3]] as int[][]                                                                  || 3
        [[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]] as int[][]                                          || 4
    }
}
