package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof66}单元测试
 * @date 2020/07/22 09:31
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof66Spec extends Specification {
    Lcof66 lcof66 = new Lcof66()

    @Unroll
    def "constructArr(#a) = #result"() {
        expect:
        result == this.lcof66.constructArr(a)

        where:
        a                        || result
        [1, 2, 3, 4, 5] as int[] || [120, 60, 40, 30, 24] as int[]
    }
}