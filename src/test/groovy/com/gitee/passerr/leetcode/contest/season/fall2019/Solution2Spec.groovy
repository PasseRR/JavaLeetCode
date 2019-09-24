package com.gitee.passerr.leetcode.contest.season.fall2019


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution2}单元测试
 * @author xiehai1* @date 2019/09/24 21:03
 * @Copyright (c)gome inc Gome Co.,LTD
 */
class Solution2Spec extends Specification {
    Solution2 solution2 = new Solution2()

    @Unroll
    def "fraction(#cont) = #result"() {
        expect:
        result == this.solution2.fraction(cont)

        where:
        cont                  || result
        [3, 2, 0, 2] as int[] || [13, 4] as int[]
        [0, 0, 3] as int[]    || [3, 1] as int[]
        [0, 0, 1] as int[]    || [1, 1] as int[]
        [1, 2] as int[]       || [3, 2] as int[]
        [2] as int[]          || [2, 1] as int[]
    }
}
