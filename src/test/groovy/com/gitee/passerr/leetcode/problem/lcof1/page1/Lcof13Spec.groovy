package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof13}单元测试
 * @date 2020/07/04 14:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof13Spec extends Specification {
    Lcof13 lcof13 = new Lcof13()

    @Unroll
    def "movingCount(#m #n, #k) == #result"() {
        expect:
        result == this.lcof13.movingCount(m, n, k)

        where:
        m | n | k || result
        2 | 3 | 1 || 3
        3 | 1 | 0 || 1
    }
}