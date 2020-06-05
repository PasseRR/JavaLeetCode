package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0207}单元测试
 * @date 2020/06/05 16:50
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0207Spec extends Specification {
    Lcci0207 lcci0207 = new Lcci0207()

    @Unroll
    def "getIntersectionNode(#head1, #head2) = #result"() {
        expect:
        result == this.lcci0207.getIntersectionNode(head1, head2)

        where:
        tail              | head1                   | head2                   || result
        ListNode.of(1, 2) | ListNode.of(tail, 3, 4) | ListNode.of(tail, 1, 2) || ListNode.of(1, 2)
        null              | ListNode.of(tail, 3, 4) | ListNode.of(tail, 1, 2) || null
    }
}