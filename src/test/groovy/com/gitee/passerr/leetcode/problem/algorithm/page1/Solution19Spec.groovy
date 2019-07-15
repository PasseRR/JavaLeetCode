package com.gitee.passerr.leetcode.problem.algorithm.page1


import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution19}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 13:18
 * @author xiehai
 */
class Solution19Spec extends Specification {
    Solution19 solution19 = new Solution19()

    @Unroll
    def "removeNthFromEnd(#node, #n) = #result"() {
        expect:
        result == this.solution19.removeNthFromEnd(node, n)

        where:
        node                       | n || result
        ListNode.of(1, 2, 3, 4, 5) | 2 || ListNode.of(1, 2, 3, 5)
        ListNode.of(1)             | 1 || null
        ListNode.of(1, 2, 3)       | 1 || ListNode.of(1, 2)
        ListNode.of(1, 2, 3)       | 3 || ListNode.of(2, 3)
    }
}
