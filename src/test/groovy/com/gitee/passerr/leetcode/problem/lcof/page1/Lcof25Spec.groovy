package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof25}单元测试
 * @date 2020/07/04 15:46
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof25Spec extends Specification {
    Lcof25 lcof25 = new Lcof25()

    @Unroll
    def "mergeTwoLists(#l1, #l2) = #result"() {
        expect:
        result == this.lcof25.mergeTwoLists(l1, l2)

        where:
        l1                   | l2                   || result
        ListNode.of(1, 4, 7) | ListNode.of(2, 5, 8) || ListNode.of(1, 2, 4, 5, 7, 8)
    }
}