package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution34}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/05 16:44
 * @author xiehai
 */
class Solution34Spec extends Specification {
    Solution34 solution34 = new Solution34()

    @Unroll
    def "searchRange(#nums, #target) = #result"() {
        expect:
        result == this.solution34.searchRange(nums, target)

        where:
        nums               | target || result
        [1, 1, 1] as int[] | 1      || [0, 2] as int[]
        [1, 2, 3] as int[] | 2      || [1, 1] as int[]
        [1, 2, 3] as int[] | 0      || [-1, -1] as int[]
    }
}
