package com.gitee.passerr.leetcode.problem.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution4}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/01 11:05
 * @author xiehai
 */
class Solution4Spec extends Specification {
    Solution4 solution4 = new Solution4()

    @Unroll
    def "findMedianSortedArrays(#nums1, #nums2) = #result"() {
        expect:
        result == this.solution4.findMedianSortedArrays(nums1, nums2)

        where:
        nums1           | nums2           || result
        [1, 3] as int[] | [2] as int[]    || 2.0
        [1, 2] as int[] | [3, 4] as int[] || 2.5
        [1] as int[]    | [] as int[]     || 1.0
    }
}
