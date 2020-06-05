package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution141}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/08 17:05
 * @author xiehai
 */
class Solution141Spec extends Specification {
    Solution141 solution141 = new Solution141()

    @Unroll
    def "hasCycle(#head) = #result"() {
        expect:
        result == this.solution141.hasCycle(head)

        where:
        head                           || result
        ({ it ->
            ListNode node1 = new ListNode(1)
            ListNode node2 = new ListNode(2)
            node1.next = node2
            ListNode node3 = new ListNode(3)
            node2.next = node3
            ListNode node4 = new ListNode(4)
            node3.next = node4
            return node1
        } as Closure<ListNode>).call() || false
    }
}
