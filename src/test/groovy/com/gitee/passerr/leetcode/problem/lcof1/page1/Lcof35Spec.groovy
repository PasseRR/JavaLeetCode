package com.gitee.passerr.leetcode.problem.lcof1.page1

import com.gitee.passerr.leetcode.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof35}单元测试
 * @date 2020/07/04 16:30
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof35Spec extends Specification {
    Lcof35 lcof35 = new Lcof35()

    @Unroll
    def "copyRandomList(#head) = #result"() {
        expect:
        result == this.lcof35.copyRandomList(head)

        where:
        head        || result
        new Node(1) || head
    }
}