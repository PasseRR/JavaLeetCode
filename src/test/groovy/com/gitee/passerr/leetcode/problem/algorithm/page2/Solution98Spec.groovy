package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution98}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/23 13:39
 * @author xiehai
 */
class Solution98Spec extends Specification {
    Solution98 solution98 = new Solution98()

    @Unroll
    def "isValidBST(#root) = #result"() {
        expect:
        result == this.solution98.isValidBST(root)

        where:
        root                                                                                   || result
        new TreeNode(
            3,
            new TreeNode(1, new TreeNode(0), new TreeNode(2)),
            new TreeNode(5, new TreeNode(4), new TreeNode(6))
        )                                                                                      || true
        new TreeNode(2, new TreeNode(1), new TreeNode(3))                                      || true
        new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))    || false
        new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(6), new TreeNode(20))) || false
    }
}
