package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution114}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/05 11:28
 * @author xiehai
 */
class Solution114Spec extends Specification {
    Solution114 solution114 = new Solution114()

    @Unroll
    def "flatten(#root)"() {
        when:
        this.solution114.flatten(root)
        then:
        result == root

        where:
        root || result
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(6))
        )    || new TreeNode(
            1,
            null,
            new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))
        )
    }
}
