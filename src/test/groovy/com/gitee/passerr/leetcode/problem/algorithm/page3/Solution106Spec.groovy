package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution106}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 11:24
 * @author xiehai
 */
class Solution106Spec extends Specification {
    Solution106 solution106 = new Solution106()

    @Unroll
    def "buildTree(#inOrder, #postOrder) = #result"() {
        expect:
        result == this.solution106.buildTree(inOrder, postOrder)

        where:
        inOrder                                      | postOrder                                    || result
        [9, 3, 15, 20, 7] as int[]                   | [9, 15, 7, 20, 3] as int[]                   || new TreeNode(
            3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
        [8, 4, 2, 5, 9, 1, 10, 6, 3, 7, 11] as int[] | [8, 4, 9, 5, 2, 10, 6, 11, 7, 3, 1] as int[] || new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5, null, new TreeNode(9))),
            new TreeNode(3, new TreeNode(6, new TreeNode(10), null), new TreeNode(7, null, new TreeNode(11)))
        )
    }
}
