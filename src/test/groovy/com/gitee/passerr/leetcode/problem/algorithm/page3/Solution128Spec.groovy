package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution128}单元测试
 * @date 2020/06/05 18:04
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution128Spec extends Specification {
    Solution128 solution128 = new Solution128()

    @Unroll
    def "longestConsecutive(#nums) = #result"() {
        expect:
        result == this.solution128.longestConsecutive(nums)

        where:
        nums                               || result
        [1, 3, 100, 200, 1, 2, 4] as int[] || 4
        [1, 3, 5, 6] as int[]              || 2
    }
}