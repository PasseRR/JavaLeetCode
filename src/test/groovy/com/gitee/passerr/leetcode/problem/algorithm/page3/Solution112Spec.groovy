package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution112}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 16:28
 * @author xiehai
 */
class Solution112Spec extends Specification {
    Solution112 solution112 = new Solution112()

    @Unroll
    def "hasPathSum(#root, #sum) = #result"() {
        expect:
        result == this.solution112.hasPathSum(root, sum)

        where:
        root                                              | sum || result
        null                                              | 0   || true
        null                                              | 1   || false
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        )                                                 | 22  || true
        new TreeNode(1)                                   | 2   || false
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) | 4   || true
    }
}
