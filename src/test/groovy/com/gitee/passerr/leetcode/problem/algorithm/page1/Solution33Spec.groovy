package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution33}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/05 15:32
 * @author xiehai
 */
class Solution33Spec extends Specification {
    Solution33 solution33 = new Solution33()

    @Unroll
    def "search(#nums, #target) = #result"() {
        expect:
        result == this.solution33.search(nums, target)

        where:
        nums                           | target || result
        [3, 1] as int[]                | 3      || 0
        [1, 3] as int[]                | 1      || 0
        [4, 5, 6, 7, 0, 1, 2] as int[] | 0      || 4
        [4, 5, 6, 7, 0, 1, 2] as int[] | 3      || -1
        [3, 5, 1] as int[]             | 3      || 0
    }
}
