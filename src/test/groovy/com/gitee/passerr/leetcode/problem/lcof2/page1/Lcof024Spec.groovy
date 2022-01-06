package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof024}单元测试
 * @date 2022/01/06 14:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof024Spec extends Specification {
    Lcof024 lcof024 = new Lcof024()

    @Unroll
    def "reverseList(#head) = #result"() {
        expect:
        result == this.lcof024.reverseList(head)

        where:
        head                       || result
        null                       || null
        ListNode.of(1)             || ListNode.of(1)
        ListNode.of(1, 2)          || ListNode.of(2, 1)
        ListNode.of(1, 2, 3, 4, 5) || ListNode.of(5, 4, 3, 2, 1)
    }
}
