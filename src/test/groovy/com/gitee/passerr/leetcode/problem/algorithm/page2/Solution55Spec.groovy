package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution55}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/12 14:39
 * @author xiehai
 */
class Solution55Spec extends Specification {
    Solution55 solution55 = new Solution55()

    @Unroll
    def "canJump(#nums) = #result"() {
        expect:
        result == this.solution55.canJump(nums)

        where:
        nums                     || result
        [0, 1] as int[]          || false
        [1, 1, 1] as int[]       || true
        [2, 3, 1, 1, 4] as int[] || true
        [3, 2, 1, 0, 4] as int[] || false
    }
}
