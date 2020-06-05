package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution103}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 16:26
 * @author xiehai
 */
class Solution103Spec extends Specification {
    Solution103 solution103 = new Solution103()

    @Unroll
    def "zigzagLevelOrder(#root) = #result"() {
        expect:
        result == this.solution103.zigzagLevelOrder(root)

        where:
        root                                                                                  || result
        new TreeNode(2, new TreeNode(1), new TreeNode(3))                                     || [[2], [3, 1]]
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || [[3], [20, 9], [15, 7]]
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, null, new TreeNode(5))
        )                                                                                     || [[1], [3, 2], [4, 5]]
    }
}
