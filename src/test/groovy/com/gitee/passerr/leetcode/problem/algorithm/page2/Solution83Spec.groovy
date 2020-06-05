package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution83}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/19 17:50
 * @author xiehai
 */
class Solution83Spec extends Specification {
    Solution83 solution83 = new Solution83()

    @Unroll
    def "deleteDuplicates(#head) = #result"() {
        expect:
        result == this.solution83.deleteDuplicates(head)

        where:
        head                       || result
        null                       || null
        ListNode.of(1)             || ListNode.of(1)
        ListNode.of(1, 1, 2)       || ListNode.of(1, 2)
        ListNode.of(1, 2)          || ListNode.of(1, 2)
        ListNode.of(1, 1, 2, 3, 3) || ListNode.of(1, 2, 3)
    }
}
