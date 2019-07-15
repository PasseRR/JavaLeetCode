package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution18}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 12:49
 * @author xiehai
 */
class Solution18Spec extends Specification {
    Solution18 solution18 = new Solution18()

    @Unroll
    def "fourSum(#nums, #target) = #result"() {
        expect:
        result == this.solution18.fourSum(nums, target)

        where:
        nums                          | target || result
        [1, 0, -1, 0, -2, 2] as int[] | 0       | [[-2, 0, 0, 2], [-2, -1, 1, 2], [-1, 0, 0, 1]]
    }
}
