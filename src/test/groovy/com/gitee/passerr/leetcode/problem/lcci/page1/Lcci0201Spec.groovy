package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0201}单元测试
 * @date 2020/06/05 16:31
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0201Spec extends Specification {
    Lcci0201 lcci0201 = new Lcci0201()

    @Unroll
    def "removeDuplicateNodes(#head) = #result"() {
        expect:
        result == this.lcci0201.removeDuplicateNodes(head)

        where:
        head                          || result
        ListNode.of(1, 2, 3, 3, 2, 1) || ListNode.of(1, 2, 3)
        ListNode.of(1, 1, 1, 1, 2)    || ListNode.of(1, 2)
    }
}