package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution113}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 16:49
 * @author xiehai
 */
class Solution113Spec extends Specification {
    Solution113 solution113 = new Solution113()

    @Unroll
    def "pathSum(#root, #sum) = #result"() {
        expect:
        result == this.solution113.pathSum(root, sum)

        where:
        root | sum || result
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        )    | 22  || [[5, 4, 11, 2], [5, 8, 4, 5]]
    }
}
