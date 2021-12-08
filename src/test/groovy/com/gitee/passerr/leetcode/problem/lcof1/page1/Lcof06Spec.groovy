package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof06}单元测试
 * @date 2020/07/04 14:29
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof06Spec extends Specification {
    Lcof06 lcof06 = new Lcof06()

    @Unroll
    def "reversePrint(#head) = #result"() {
        expect:
        result == this.lcof06.reversePrint(head)

        where:
        head                 || result
        ListNode.of(1, 2, 3) || [3, 2, 1] as int[]
    }
}