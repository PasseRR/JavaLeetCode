package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof11}单元测试
 * @date 2020/07/04 14:45
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class lcof11Spec extends Specification {
    Lcof11 lcof11 = new Lcof11()

    @Unroll
    def "minArray(#numbers) = #result"() {
        expect:
        result == this.lcof11.minArray(numbers)

        where:
        numbers                  || result
        [3, 4, 5, 1, 2] as int[] || 1
        [2, 2, 2, 0, 1] as int[] || 0
    }
}