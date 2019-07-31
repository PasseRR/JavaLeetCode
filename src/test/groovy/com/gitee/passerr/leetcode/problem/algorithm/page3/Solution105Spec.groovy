package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution105}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 10:15
 * @author xiehai
 */
class Solution105Spec extends Specification {
    Solution105 solution105 = new Solution105()

    @Unroll
    def "buildTree(#preOrder, #inOrder) = #result"() {
        expect:
        result == this.solution105.buildTree(preOrder, inOrder)

        where:
        preOrder                                     | inOrder                                      || result
        [3, 9, 20, 15, 7] as int[]                   | [9, 3, 15, 20, 7] as int[]                   || new TreeNode(
            3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
        [1, 2, 4, 8, 5, 9, 3, 6, 10, 7, 11] as int[] | [8, 4, 2, 5, 9, 1, 10, 6, 3, 7, 11] as int[] || new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5, null, new TreeNode(9))),
            new TreeNode(3, new TreeNode(6, new TreeNode(10), null), new TreeNode(7, null, new TreeNode(11)))
        )
    }
}
