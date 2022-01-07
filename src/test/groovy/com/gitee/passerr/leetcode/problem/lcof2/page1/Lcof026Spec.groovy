package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof026}单元测试
 * @date 2022/01/07 10:16
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof026Spec extends Specification {
    Lcof026 lcof026 = new Lcof026()

    @Unroll
    def "reorderList(#head) = #result"() {
        when:
        this.lcof026.reorderList(head)
        then:
        head == result

        where:
        head                       || result
        ListNode.of(1, 2, 3, 4)    || ListNode.of(1, 4, 2, 3)
        ListNode.of(1, 2, 3, 4, 5) || ListNode.of(1, 5, 2, 4, 3)
    }
}
