package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof64}单元测试
 * @date 2020/07/22 09:27
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof64Spec extends Specification {
    Lcof64 lcof64 = new Lcof64()

    @Unroll
    def "sumNums(#n) = #result"() {
        expect:
        result == this.lcof64.sumNums(n)

        where:
        n || result
        3 || 6
        9 || 45
    }
}