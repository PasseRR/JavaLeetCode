package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution107}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 13:08
 * @author xiehai
 */
class Solution107Spec extends Specification {
    Solution107 solution107 = new Solution107()

    @Unroll
    def "levelOrderBottom(#root) = #result"() {
        expect:
        result == this.solution107.levelOrderBottom(root)

        where:
        root                                                                                  || result
        new TreeNode(2, new TreeNode(1), new TreeNode(3))                                     || [[1, 3], [2]]
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))) || [[15, 7], [9, 20], [3]]
    }
}
