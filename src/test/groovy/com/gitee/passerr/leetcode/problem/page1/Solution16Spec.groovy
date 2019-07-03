package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution16}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 18:28
 * @author xiehai
 */
class Solution16Spec extends Specification {
    Solution16 solution16 = new Solution16()

    @Unroll
    def "threeSumClosest(#nums, #target) = #result"() {
        expect:
        result == this.solution16.threeSumClosest(nums, target)

        where:
        nums                         | target || result
        [-3, -2, -5, 3, -4] as int[] | -1     || -2
        [-1, 2, 1, -4] as int[]      | 1      || 2
    }
}
