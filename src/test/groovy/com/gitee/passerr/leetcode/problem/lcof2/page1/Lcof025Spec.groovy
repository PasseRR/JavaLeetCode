package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof025}单元测试
 * @date 2022/01/06 17:38
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof025Spec extends Specification {
    Lcof025 lcof025 = new Lcof025()

    @Unroll
    def "addTwoNumbers(#l1, #l2) = #result"() {
        expect:
        result == this.lcof025.addTwoNumbers(l1, l2)

        where:
        l1                      | l2                   || result
        ListNode.of(7, 2, 4, 3) | ListNode.of(5, 6, 4) || ListNode.of(7, 8, 0, 7)
        ListNode.of(2, 4, 3)    | ListNode.of(5, 6, 4) || ListNode.of(8, 0, 7)
        ListNode.of(0)          | ListNode.of(0)       || ListNode.of(0)
    }
}
