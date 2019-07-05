package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution31}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/05 10:39
 * @author xiehai
 */
class Solution31Spec extends Specification {
    Solution31 solution31 = new Solution31()

    @Unroll
    def "nextPermutation(#nums), after(#result)"() {
        when:
        this.solution31.nextPermutation(nums)
        then:
        result == nums

        where:
        nums                           || result
        [1, 2, 3] as int[]             || [1, 3, 2] as int[]
        [3, 2, 1] as int[]             || [1, 2, 3] as int[]
        [1, 1, 5] as int[]             || [1, 5, 1] as int[]
        [1, 3, 2] as int[]             || [2, 1, 3] as int[]
        [1, 2, 4, 3] as int[]          || [1, 3, 2, 4] as int[]
        [4, 2, 0, 2, 3, 2, 0] as int[] || [4, 2, 0, 3, 0, 2, 2] as int[]
    }
}
