package com.gitee.passerr.leetcode.contest.season.fall2019


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution4}单元测试
 * @author xiehai1* @date 2019/09/24 21:03
 * @Copyright (c)gome inc Gome Co.,LTD
 */
class Solution4Spec extends Specification {
    Solution4 solution4 = new Solution4()

    @Unroll
    def "domino(#n, #m, #blocks) = #result"() {
        expect:
        result == this.solution4.domino(n, m, blocks)

        where:
        n | m | blocks                      || result
        1 | 1 | [] as int[][]               || 0
        2 | 1 | [[0, 0]] as int[][]         || 0
        1 | 2 | [[0, 0]] as int[][]         || 0
        2 | 3 | [[1, 0], [1, 1]] as int[][] || 2
        3 | 3 | [] as int[][]               || 4
        4 | 4 | [] as int[][]               || 8
    }
}
