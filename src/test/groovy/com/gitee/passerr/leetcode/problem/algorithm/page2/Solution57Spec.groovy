package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution57}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/12 16:32
 * @author xiehai
 */
class Solution57Spec extends Specification {
    Solution57 solution57 = new Solution57()

    @Unroll
    def "insert(#intervals, #newInterval) = #result"() {
        when:
        def insert = this.solution57.insert(intervals, newInterval)
        then:
        insert.length.times { it ->
            assert Arrays.toString(insert[it]) == Arrays.toString(result[it])
        }

        where:
        intervals                                              | newInterval     || result
        [[3, 5]] as int[][]                                    | [1, 2] as int[] || [[1, 2], [3, 5]] as int[][]
        [[3, 5]] as int[][]                                    | [6, 7] as int[] || [[3, 5], [6, 7]] as int[][]
        [[1, 3], [6, 9]] as int[][]                            | [2, 5] as int[] || [[1, 5], [6, 9]] as int[][]
        [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]] as int[][] | [4, 8] as int[] || [[1, 2], [3, 10], [12, 16]] as
            int[][]
    }
}
