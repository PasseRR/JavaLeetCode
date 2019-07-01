package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution1}单元测试
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/06/28 15:57
 * @author xiehai
 */
class Solution1Spec extends Specification {
    Solution1 solution1 = new Solution1()

    @Unroll
    def "twoSum(#array, #target) = #result"() {
        expect:
        result == this.solution1.twoSum(array, target)

        where:
        array                   | target || result
        [2, 7, 11, 15] as int[] | 9      || [0, 1] as int[]
    }
}
