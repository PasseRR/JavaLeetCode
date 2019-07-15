package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution56}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/12 15:18
 * @author xiehai
 */
class Solution56Spec extends Specification {
    Solution56 solution56 = new Solution56()

    @Unroll
    def "merge(#intervals) = #result"() {
        when:
        def merge = this.solution56.merge(intervals)
        then:
        merge.length.times { it ->
            assert Arrays.toString(merge[it]) == Arrays.toString(result[it])
        }

        where:
        intervals                                      || result
        [[1, 3], [2, 6], [8, 10], [15, 18]] as int[][] || [[1, 6], [8, 10], [15, 18]] as int[][]
        [[1, 4], [2, 3]] as int[][]                    || [[1, 4]] as int[][]
    }
}
