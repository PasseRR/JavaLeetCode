package com.gitee.passerr.leetcode.problem.lcof1.page2

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof52}单元测试
 * @date 2020/07/14 16:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof52Spec extends Specification {
    Lcof52 lcof52 = new Lcof52()

    @Unroll
    def "getIntersectionNode(#headA, #headB) = #result"() {
        expect:
        result == this.lcof52.getIntersectionNode(headA, headB)

        where:
        suffix               | headA                     | headB                        || result
        ListNode.of(1, 2, 3) | ListNode.of(suffix, 1, 1) | ListNode.of(suffix, 1, 2, 3) || suffix
        null                 | ListNode.of(1, 2, 3)      | ListNode.of(1, 2, 3)         || null
    }
}