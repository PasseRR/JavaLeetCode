package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.ListNode
import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution109}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 14:14
 * @author xiehai
 */
class Solution109Spec extends Specification {
    Solution109 solution109 = new Solution109()

    @Unroll
    def "sortedListToBST(#head) = #result"() {
        expect:
        result == this.solution109.sortedListToBST(head)

        where:
        head                          || result
        ListNode.of(-10, -3, 0, 5, 9) || new TreeNode(
            0,
            new TreeNode(-10, null, new TreeNode(-3)),
            new TreeNode(5, null, new TreeNode(9))
        )
    }
}
