package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution102}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/25 15:59
 * @author xiehai
 */
class Solution102Spec extends Specification {
    Solution102 solution102 = new Solution102()

    @Unroll
    def "levelOrder(#root) = #result"() {
        expect:
        result == this.solution102.levelOrder(root)

        where:
        root                                                                                  || result
        new TreeNode(2, new TreeNode(1), new TreeNode(3))                                     || [[2], [1, 3]]
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || [[3], [9, 20], [15, 7]]
    }
}
