package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution90}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/24 16:05
 * @author xiehai
 */
class Solution90Spec extends Specification {
    Solution90 solution90 = new Solution90()

    @Unroll
    def "subsetsWithDup(#nums) = #result"() {
        expect:
        result == this.solution90.subsetsWithDup(nums)

        where:
        nums                     || result
        [1, 2, 2] as int[]       || [[1, 2, 2], [1], [], [2], [2, 2], [1, 2]]
        [4, 4, 4, 1, 4] as int[] || [[1], [1, 4, 4], [], [4, 4], [4], [4, 4, 4], [1, 4], [4, 4, 4, 1, 4], [1, 4, 4, 4], [4, 4, 4, 4]]
    }
}
