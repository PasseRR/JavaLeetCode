package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof62}单元测试
 * @date 2020/07/22 09:22
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof62Spec extends Specification {
    Lcof62 lcof62 = new Lcof62()

    @Unroll
    def "lastRemaining(#n, #m) = #result"() {
        expect:
        result == this.lcof62.lastRemaining(n, m)

        where:
        n  | m  || result
        5  | 3  || 3
        10 | 17 || 2
    }
}