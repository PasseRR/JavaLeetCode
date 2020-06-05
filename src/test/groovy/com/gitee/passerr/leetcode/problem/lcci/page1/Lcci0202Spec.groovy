package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0202}单元测试
 * @date 2020/06/05 16:35
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0202Spec extends Specification {
    Lcci0202 lcci0202 = new Lcci0202()

    @Unroll
    def "kthToLast(#head, #k) == #result"() {
        expect:
        result == this.lcci0202.kthToLast(head, k)

        where:
        head                       | k || result
        ListNode.of(1, 2, 3, 4, 5) | 2 || 4
    }
}