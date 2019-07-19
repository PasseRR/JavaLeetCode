package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution80}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 15:35
 * @author xiehai
 */
class Solution80Spec extends Specification {
    Solution80 solution80 = new Solution80()

    @Unroll
    def "removeDuplicates(#nums) = #result"() {
        expect:
        result == this.solution80.removeDuplicates(nums)

        where:
        nums                                 || result
        [1, 1, 1, 2, 2, 3] as int[]          || 5
        [0, 0, 1, 1, 1, 1, 2, 3, 3] as int[] || 7
        [1, 1, 1, 2, 2, 2, 3, 3] as int[]    || 6
    }
}
