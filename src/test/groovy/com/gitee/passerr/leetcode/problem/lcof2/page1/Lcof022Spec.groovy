package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof022}单元测试
 * @date 2022/01/06 11:38
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof022Spec extends Specification {
    Lcof022 lcof022 = new Lcof022()

    @Unroll
    def "detectCycle(#head) = #result"() {
        expect:
        result == this.lcof022.detectCycle(head)

        where:
        head                 || result
        ListNode.of(1, 2, 3) || null
    }
}
