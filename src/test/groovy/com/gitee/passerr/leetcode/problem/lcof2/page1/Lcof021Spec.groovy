package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof021}单元测试
 * @date 2022/01/06 10:08
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof021Spec extends Specification {
    Lcof021 lcof021 = new Lcof021()

    @Unroll
    def "removeNthFromEnd(#head, #n) = #result"() {
        expect:
        result == this.lcof021.removeNthFromEnd(head, n)
        println result

        where:
        head                       | n || result
        ListNode.of(1, 2, 3, 4, 5) | 1 || ListNode.of(1, 2, 3, 4)
        ListNode.of(1, 2, 3, 4, 5) | 2 || ListNode.of(1, 2, 3, 5)
        ListNode.of(1, 2, 3, 4, 5) | 3 || ListNode.of(1, 2, 4, 5)
        ListNode.of(1, 2, 3, 4, 5) | 4 || ListNode.of(1, 3, 4, 5)
        ListNode.of(1, 2, 3, 4, 5) | 5 || ListNode.of(2, 3, 4, 5)
    }
}
