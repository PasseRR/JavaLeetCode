package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution47}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 19:26
 * @author xiehai
 */
class Solution47Spec extends Specification {
    Solution47 solution47 = new Solution47()

    @Unroll
    def "permuteUnique(#nums) = #result"() {
        expect:
        result == this.solution47.permuteUnique(nums)

        where:
        nums               || result
        [1, 1, 2] as int[] || [[1, 1, 2], [2, 1, 1], [1, 2, 1]]
    }
}
