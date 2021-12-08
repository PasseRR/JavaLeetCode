package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof22}单元测试
 * @date 2020/07/04 15:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof22Spec extends Specification {
    Lcof22 lcof22 = new Lcof22()

    @Unroll
    def "getKthFromEnd(#head, #k) == #result"() {
        expect:
        result == this.lcof22.getKthFromEnd(head, k)

        where:
        head                    | k || result
        ListNode.of(1, 2, 3, 4) | 2 || head.next.next
    }
}