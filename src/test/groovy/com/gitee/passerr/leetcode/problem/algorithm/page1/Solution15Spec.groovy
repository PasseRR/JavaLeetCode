package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution15} 测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/02 16:58
 * @author xiehai
 */
class Solution15Spec extends Specification {
    Solution15 solution15 = new Solution15()

    @Unroll
    def "threeSum(#input) = #result"() {
        expect:
        result == this.solution15.threeSum(input)

        where:
        input                          || result
        [-1, 0, 1, 2, -1, -4] as int[] || [[-1, -1, 2], [-1, 0, 1]]
    }
}
