package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution40}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/09 11:24
 * @author xiehai
 */
class Solution40Spec extends Specification {
    Solution40 solution40 = new Solution40()

    @Unroll
    def "combinationSum2(#nums, #target) = #result"() {
        expect:
        result == this.solution40.combinationSum2(nums, target)

        where:
        nums                            | target || result
        [10, 1, 2, 7, 6, 1, 5] as int[] | 8      || [[1, 2, 5], [1, 1, 6], [2, 6], [1, 7]]
        [2, 5, 2, 1, 2] as int[]        | 5      || [[1, 2, 2], [5]]
    }
}
