package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution101}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 15:43
 * @author xiehai
 */
class Solution101Spec extends Specification {
    Solution101 solution101 = new Solution101()

    @Unroll
    def "isSymmetric(#root) = #result"() {
        expect:
        result == this.solution101.isSymmetric(root)

        where:
        root                                              || result
        null                                              || true
        new TreeNode(1)                                   || true
        new TreeNode(1, new TreeNode(2), new TreeNode(2)) || true
        new TreeNode(1, new TreeNode(2), new TreeNode(1)) || false
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(3), new TreeNode(4))
        )                                                 || true
    }
}
