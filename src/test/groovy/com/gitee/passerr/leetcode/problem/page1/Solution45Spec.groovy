package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution45}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 17:00
 * @author xiehai
 */
class Solution45Spec extends Specification {
    Solution45 solution45 = new Solution45()

    @Unroll
    def "jump(#nums) = #result"() {
        expect:
        result == this.solution45.jump(nums)

        where:
        nums                     || result
        [1, 2, 3] as int[]       || 2
        [2, 1] as int[]          || 1
        [2, 3, 1, 1, 4] as int[] || 2
        [1, 1, 1, 1] as int[]    || 3
    }
}
