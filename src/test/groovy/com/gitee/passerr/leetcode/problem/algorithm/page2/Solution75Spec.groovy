package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution75}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/17 18:28
 * @author xiehai
 */
class Solution75Spec extends Specification {
    Solution75 solution75 = new Solution75()

    @Unroll
    def "sortColors(#nums) = #result"() {
        when:
        this.solution75.sortColors(nums)
        then:
        Arrays.toString(nums) == Arrays.toString(result)

        where:
        nums                        || result
        [2, 0, 2, 1, 1, 0] as int[] || [0, 0, 1, 1, 2, 2] as int[]
    }
}
