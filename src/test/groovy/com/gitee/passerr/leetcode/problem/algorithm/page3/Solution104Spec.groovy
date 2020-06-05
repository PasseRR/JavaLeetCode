package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution104}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 17:18
 * @author xiehai
 */
class Solution104Spec extends Specification {
    Solution104 solution104 = new Solution104()

    @Unroll
    def "maxDepth(#root) = #result"() {
        expect:
        result == this.solution104.maxDepth(root)

        where:
        root                                   || result
        null                                   || 0
        new TreeNode(1)                        || 1
        new TreeNode(1, new TreeNode(1), null) || 2
        new TreeNode(1, null, new TreeNode(1)) || 2
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(6))
        )                                      || 3
    }
}
