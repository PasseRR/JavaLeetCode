package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution81}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 16:12
 * @author xiehai
 */
class Solution81Spec extends Specification {
    Solution81 solution81 = new Solution81()

    @Unroll
    def "search(#nums, #target) = #result"() {
        expect:
        result == this.solution81.search(nums, target)

        where:
        nums                           | target || result
        [] as int[]                    | 1      || false
        [1] as int[]                   | 1      || true
        [7, 2, 3, 5, 6] as int[]       | 3      || true
        [7, 2, 3, 5, 6] as int[]       | 4      || false
        [2, 5, 6, 0, 0, 1, 2] as int[] | 0      || true
        [2, 5, 6, 0, 0, 1, 2] as int[] | 5      || true
        [2, 5, 6, 0, 0, 1, 2] as int[] | 3      || false
        [2, 5, 6, 0, 0, 1, 2] as int[] | 4      || false
    }
}
