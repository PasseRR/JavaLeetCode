package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution42}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/09 14:01
 * @author xiehai
 */
class Solution42Spec extends Specification {
    Solution42 solution42 = new Solution42()

    @Unroll
    def "trap(#nums) = #result"() {
        expect:
        result == this.solution42.trap(nums)

        where:
        nums                                          || result
//        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] || 6
        [5, 5, 1, 7, 1, 1, 5, 2, 7, 6] as int[]       || 23
    }
}
