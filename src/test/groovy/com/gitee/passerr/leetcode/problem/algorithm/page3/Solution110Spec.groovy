package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution110}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 14:50
 * @author xiehai
 */
class Solution110Spec extends Specification {
    Solution110 solution110 = new Solution110()

    @Unroll
    def "isBalanced(#root) = #result"() {
        expect:
        result == this.solution110.isBalanced(root)

        where:
        root                                                          || result
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
            new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))
        )                                                             || false
        null                                                          || true
        new TreeNode(1)                                               || true
        new TreeNode(1, new TreeNode(2), new TreeNode(3))             || true
        new TreeNode(1, new TreeNode(2, new TreeNode(1), null), null) || false
    }
}
