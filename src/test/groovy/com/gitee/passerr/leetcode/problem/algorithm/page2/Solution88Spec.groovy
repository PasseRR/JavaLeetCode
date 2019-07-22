package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution88}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/22 17:18
 * @author xiehai
 */
class Solution88Spec extends Specification {
    Solution88 solution88 = new Solution88()

    @Unroll
    def "merge(#nums1, #m, #nums2, #n) = #result"() {
        when:
        this.solution88.merge(nums1, m, nums2, n)
        then:
        result == nums1

        where:
        nums1                       | m | nums2              | n || result
        [1, 2, 3, 0, 0, 0] as int[] | 3 | [2, 5, 6] as int[] | 3 || [1, 2, 2, 3, 5, 6] as int[]
    }
}
