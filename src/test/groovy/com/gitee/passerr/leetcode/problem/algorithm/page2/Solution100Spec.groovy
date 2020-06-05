package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution100}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/23 11:23
 * @author xiehai
 */
class Solution100Spec extends Specification {
    Solution100 solution100 = new Solution100()

    @Unroll
    def "isSameTree(#p, #q) = #result"() {
        expect:
        result == this.solution100.isSameTree(p, q)

        where:
        p                                                 | q                                                 || result
        new TreeNode(1, new TreeNode(2), new TreeNode(3)) | new TreeNode(1, new TreeNode(2), new TreeNode(3)) || true
        new TreeNode(1, new TreeNode(2), null)            | new TreeNode(1, null, new TreeNode(2))            || false
    }
}
