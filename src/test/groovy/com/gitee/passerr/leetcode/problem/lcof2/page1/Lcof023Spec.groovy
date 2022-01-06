package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof023}单元测试
 * @date 2022/01/06 13:47
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof023Spec extends Specification {
    Lcof023 lcof023 = new Lcof023()

    @Unroll
    def "getIntersectionNode(#headA, #headB) = #result"() {
        expect:
        result == this.lcof023.getIntersectionNode(headA, headB)

        where:
        suffix               | headA                     | headB                        || result
        ListNode.of(1, 2, 3) | ListNode.of(suffix, 1, 1) | ListNode.of(suffix, 1, 2, 3) || suffix
        null                 | ListNode.of(1, 2, 3)      | ListNode.of(1, 2, 3)         || null
    }
}
