package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution94}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/24 11:27
 * @author xiehai
 */
class Solution94Spec extends Specification {
    Solution94 solution94 = new Solution94()

    @Unroll
    def "inorderTraversal(#root) = #result"() {
        expect:
        result == this.solution94.inorderTraversal(root)

        where:
        root                                                          || result
        new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)) || [1, 3, 2]
    }
}
