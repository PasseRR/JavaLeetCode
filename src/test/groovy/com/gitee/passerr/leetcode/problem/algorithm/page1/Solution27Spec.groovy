package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution27}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 14:57
 * @author xiehai
 */
class Solution27Spec extends Specification {
    Solution27 solution27 = new Solution27()

    @Unroll
    def "removeElement(#nums, #val) = #result"() {
        expect:
        result == this.solution27.removeElement(nums, val)

        where:
        nums                              | val || result
        [1, 2, 1, 2, 1] as int[]          | 2   || 3
        [1, 2, 1, 2, 1] as int[]          | 1   || 2
        [0, 1, 2, 2, 3, 0, 4, 2] as int[] | 2   || 5
    }
}
