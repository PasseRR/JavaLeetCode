package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution144}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 09:09
 * @author xiehai
 */
class Solution144Spec extends Specification {
    Solution144 solution144 = new Solution144()

    @Unroll
    def "preorderTraversal(#root) = #result"() {
        expect:
        result == this.solution144.preorderTraversal(root)

        where:
        root                                                          || result
        new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))) || [1, 2, 3]
    }
}
