package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0806}单元测试
 * @date 2020/07/31 13:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0806Spec extends Specification {
    Lcci0806 lcci0806 = new Lcci0806()

    @Unroll
    def "hanota(#a, #b, #c)"() {
        when:
        this.lcci0806.hanota(a, b, c)
        then:
        result == c

        where:
        a         | b  | c  || result
        [2, 1, 0] | [] | [] || [2, 1, 0]
    }
}