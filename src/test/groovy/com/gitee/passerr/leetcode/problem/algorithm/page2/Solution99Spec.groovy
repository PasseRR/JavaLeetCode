package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution99}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 15:14
 * @author xiehai
 */
class Solution99Spec extends Specification {
    Solution99 solution99 = new Solution99()

    @Unroll
    def "recoverTree(#root) = #result"() {
        when:
        this.solution99.recoverTree(root)
        then:
        result == root

        where:
        root                                                          || result
        new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null) || new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null)
    }
}
