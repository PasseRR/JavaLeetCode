package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof33}单元测试
 * @date 2020/07/04 16:20
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof33Spec extends Specification {
    Lcof33 lcof33 = new Lcof33()

    @Unroll
    def "verifyPostorder(#postOrder) = #result"() {
        expect:
        result == this.lcof33.verifyPostorder(postOrder)

        where:
        postOrder                || result
        [1, 6, 3, 2, 5] as int[] || false
        [1, 3, 2, 6, 5] as int[] || true
    }
}