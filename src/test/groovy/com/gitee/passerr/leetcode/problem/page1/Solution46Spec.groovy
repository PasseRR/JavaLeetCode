package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution46}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 19:18
 * @author xiehai
 */
class Solution46Spec extends Specification {
    Solution46 solution46 = new Solution46()

    @Unroll
    def "permute(#nums) = #result"() {
        expect:
        result == this.solution46.permute(nums)

        where:
        nums               || result
        [1, 2, 3] as int[] || [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
