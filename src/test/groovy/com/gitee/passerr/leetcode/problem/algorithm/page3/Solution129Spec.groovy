package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution129}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/01 14:05
 * @author xiehai
 */
class Solution129Spec extends Specification {
    Solution129 solution129 = new Solution129()

    @Unroll
    def "sumNumbers(#root) = #result"() {
        expect:
        result == this.solution129.sumNumbers(root)

        where:
        root                                                                                || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3))                                   || 25
        new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0)) || 1026
    }
}
