package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution82}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 16:57
 * @author xiehai
 */
class Solution82Spec extends Specification {
    Solution82 solution82 = new Solution82()

    @Unroll
    def "deleteDuplicates(#head) = #result"() {
        expect:
        result == this.solution82.deleteDuplicates(head)

        where:
        head                          || result
        ListNode.of(1, 1, 2, 2, 3, 4) || ListNode.of(3, 4)
        ListNode.of(1, 2, 2, 3, 3, 4) || ListNode.of(1, 4)
        ListNode.of(1, 2)             || ListNode.of(1, 2)
        ListNode.of(2, 1)             || ListNode.of(2, 1)
    }
}
