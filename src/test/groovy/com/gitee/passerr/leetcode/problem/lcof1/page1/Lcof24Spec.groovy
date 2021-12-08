package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof24}单元测试
 * @date 2020/07/04 15:43
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof24Spec extends Specification {
    Lcof24 lcof24 = new Lcof24()

    @Unroll
    def "reverseList(#head) = #result"() {
        expect:
        result == this.lcof24.reverseList(head)

        where:
        head                       || result
        ListNode.of(1, 2, 3, 4, 5) || ListNode.of(5, 4, 3, 2, 1)
    }
}