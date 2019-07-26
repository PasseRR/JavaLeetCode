package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution95}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 10:57
 * @author xiehai
 */
class Solution95Spec extends Specification {
    Solution95 solution95 = new Solution95()

    @Unroll
    def "generateTrees(#n) = #result"() {
        expect:
        result == this.solution95.generateTrees(n)

        where:
        n || result
        0 || []
        1 || [new TreeNode(1)]
        2 || [new TreeNode(1, null, new TreeNode(2)), new TreeNode(2, new TreeNode(1), null)]
        3 || [
            new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))),
            new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)),
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null),
            new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null)
        ]
    }
}
