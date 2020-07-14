package com.gitee.passerr.leetcode.problem.lcof.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof46}单元测试
 * @date 2020/07/14 13:10
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof46Spec extends Specification {
    Lcof46 lcof46 = new Lcof46()

    @Unroll
    def "translateNum(#num) = #result"() {
        expect:
        result == this.lcof46.translateNum(num)

        where:
        num   || result
        12258 || 5
        1     || 1
        21    || 2
    }
}