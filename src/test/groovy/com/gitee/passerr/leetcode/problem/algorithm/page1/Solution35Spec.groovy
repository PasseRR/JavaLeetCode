package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution35}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/05 17:04
 * @author xiehai
 */
class Solution35Spec extends Specification {
    Solution35 solution35 = new Solution35()

    @Unroll
    def "searchInsert(#nums, #target) = #result"() {
        expect:
        result == this.solution35.searchInsert(nums, target)

        where:
        nums                      | target || result
        [3, 5, 7, 9, 10] as int[] | 8      || 3
        [] as int[]               | 1      || 0
        [1, 3] as int[]           | 2      || 1
        [1, 3, 5, 6] as int[]     | 5      || 2
        [1, 3, 5, 6] as int[]     | 2      || 1
        [1, 3, 5, 6] as int[]     | 7      || 4
        [1, 3, 5, 6] as int[]     | 0      || 0
    }
}
