package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0205}单元测试
 * @date 2020/06/05 16:44
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0205Spec extends Specification {
    Lcci0205 lcci0205 = new Lcci0205()

    @Unroll
    def "addTwoNumbers(#node1, #node2) = #result"() {
        expect:
        result == this.lcci0205.addTwoNumbers(node1, node2)

        where:
        node1                   | node2                || result
        ListNode.of(2, 4, 3)    | ListNode.of(5, 6, 4) || ListNode.of(7, 0, 8)
        ListNode.of(5)          | ListNode.of(5)       || ListNode.of(0, 1)
        ListNode.of(3, 4, 5, 1) | ListNode.of(5, 4, 3) || ListNode.of(8, 8, 8, 1)
    }
}