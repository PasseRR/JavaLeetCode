package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution108}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 13:56
 * @author xiehai
 */
class Solution108Spec extends Specification {
    Solution108 solution108 = new Solution108()

    @Unroll
    def "sortedArrayToBST(#nums) = #result"() {
        expect:
        result == this.solution108.sortedArrayToBST(nums)

        where:
        nums                        || result
        [-10, -3, 0, 5, 9] as int[] || new TreeNode(
            0,
            new TreeNode(-10, null, new TreeNode(-3)),
            new TreeNode(5, null, new TreeNode(9))
        )
    }
}
