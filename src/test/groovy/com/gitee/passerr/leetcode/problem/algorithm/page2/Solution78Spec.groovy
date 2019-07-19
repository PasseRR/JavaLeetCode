package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution78}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 13:33
 * @author xiehai
 */
class Solution78Spec extends Specification {
    Solution78 solution78 = new Solution78()

    @Unroll
    def "subsets(#nums) = #result"() {
        expect:
        result == this.solution78.subsets(nums)

        where:
        nums               || result
        [1, 2, 3] as int[] || [[], [1, 2, 3], [1], [2], [3], [1, 2], [1, 3], [2, 3]]
    }
}
