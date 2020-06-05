package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0208}单元测试
 * @date 2020/06/05 16:58
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0208Spec extends Specification {
    Lcci0208 lcci0208 = new Lcci0208()

    @Unroll
    def "detectCycle(#head) = #result"() {
        expect:
        result == this.lcci0208.detectCycle(head)

        where:
        head                 || result
        ListNode.of(1, 2, 3) || null
    }
}