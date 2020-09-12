package com.gitee.passerr.leetcode.contest.season.fall2020

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution2}单元测试
 * @date 2020/09/12 15:18
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution2Spec extends Specification {
    Solution2 solution2 = new Solution2()

    @Unroll
    def "breakfastNumber(#staple, #drinks, #x) = #result"() {
        expect:
        result == this.solution2.breakfastNumber(staple, drinks, x)

        where:
        staple               | drinks                | x  || result
        [10, 20, 5] as int[] | [5, 5, 2] as int[]    | 15 || 6
        [2, 1, 1] as int[]   | [8, 9, 5, 1] as int[] | 9  || 8
    }
}