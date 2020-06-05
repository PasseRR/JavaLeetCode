package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0204}单元测试
 * @date 2020/06/05 16:41
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0204Spec extends Specification {
    Lcci0204 lcci0204 = new Lcci0204()

    @Unroll
    def "partition(#head, #x) == #result"() {
        expect:
        result == this.lcci0204.partition(head, x)

        where:
        head                              | x || result
        ListNode.of(3, 5, 8, 5, 10, 2, 1) | 5 || ListNode.of(3, 2, 1, 5, 8, 5, 10)
    }
}