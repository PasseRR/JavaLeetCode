package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution41}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/09 11:45
 * @author xiehai
 */
class Solution41Spec extends Specification {
    Solution41 solution41 = new Solution41()

    @Unroll
    def "firstMissingPositive(#nums) = #result"() {
        expect:
        result == this.solution41.firstMissingPositive(nums)

        where:
        nums                        || result
        [1, 2, 0] as int[]          || 3
        [3, 4, -1, 1] as int[]      || 2
        [7, 8, 9, 11, 12] as int[]  || 1
        [1, 2, 4, 5] as int[]       || 3
        [1, 2, 3, 5] as int[]       || 4
        [1, 2, 3, 5, 7, 8] as int[] || 4
        [] as int[]                 || 1
        [1] as int[]                || 2
    }
}
