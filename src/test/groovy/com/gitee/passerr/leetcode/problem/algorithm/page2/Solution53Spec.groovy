package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution53}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/11 15:50
 * @author xiehai
 */
class Solution53Spec extends Specification {
    Solution53 solution53 = new Solution53()

    @Unroll
    def "maxSubArray(#nums) = #result"() {
        expect:
        result == this.solution53.maxSubArray(nums)

        where:
        nums                                     || result
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] || 6
    }
}
