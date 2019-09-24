package com.gitee.passerr.leetcode.contest.season.fall2019


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution4}单元测试
 * @author xiehai1* @date 2019/09/24 21:03
 * @Copyright (c)gome inc Gome Co.,LTD
 */
class Solution5Spec extends Specification {
    Solution5 solution5 = new Solution5()

    @Unroll
    def "bonus(#n, #leadership, #operations) = #result"() {
        expect:
        result == this.solution5.bonus(n, leadership, operations)

        where:
        n | leadership                                          | operations                                                       || result
        6 | [[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]] as int[][] | [[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]] as int[][] || [650, 665] as int[]
    }
}
