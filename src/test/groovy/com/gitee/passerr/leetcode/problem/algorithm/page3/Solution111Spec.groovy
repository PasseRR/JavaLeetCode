package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution111}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 15:19
 * @author xiehai
 */
class Solution111Spec extends Specification {
    Solution111 solution111 = new Solution111()

    @Unroll
    def "minDepth(#root) = #result"() {
        expect:
        result == this.solution111.minDepth(root)

        where:
        root                                                                                  || result
        null                                                                                  || 0
        new TreeNode(1, new TreeNode(2), null)                                                || 2
        new TreeNode(1)                                                                       || 1
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || 2
    }
}
