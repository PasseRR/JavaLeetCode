package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution145}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 09:14
 * @author xiehai
 */
class Solution145Spec extends Specification {
    Solution145 solution145 = new Solution145()

    @Unroll
    def "postorderTraversal(#root) = #result"() {
        expect:
        result == this.solution145.postorderTraversal(root)

        where:
        root                                                          || result
        new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))) || [3, 2, 1]
    }
}
