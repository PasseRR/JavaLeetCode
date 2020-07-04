package com.gitee.passerr.leetcode.problem.lcof.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof18}单元测试
 * @date 2020/07/04 15:05
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof18Spec extends Specification {
    Lcof18 lcof18 = new Lcof18()

    @Unroll
    def "deleteNode(#head, #val) == #result"() {
        expect:
        result.is this.lcof18.deleteNode(head, val)

        where:
        head                    | val || result
        ListNode.of(1, 2, 3, 4) | 1   || head.next
    }
}