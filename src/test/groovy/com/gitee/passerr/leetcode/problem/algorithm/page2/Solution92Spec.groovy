package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution92}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/24 13:36
 * @author xiehai
 */
class Solution92Spec extends Specification {
    Solution92 solution92 = new Solution92()

    @Unroll
    def "reverseBetween(#head, #m, #n) = #result"() {
        expect:
        result == this.solution92.reverseBetween(head, m, n)

        where:
        head                       | m | n || result
        ListNode.of(1, 2, 3, 4, 5) | 1 | 3 || ListNode.of(3, 2, 1, 4, 5)
        ListNode.of(1, 2, 3, 4, 5) | 2 | 3 || ListNode.of(1, 3, 2, 4, 5)
        ListNode.of(1, 2, 3, 4, 5) | 3 | 5 || ListNode.of(1, 2, 5, 4, 3)
    }
}
