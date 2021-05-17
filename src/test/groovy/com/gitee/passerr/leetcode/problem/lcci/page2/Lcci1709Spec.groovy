package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1709}单元测试
 * @date 2021/05/17 17:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1709Spec extends Specification {
    Lcci1709 lcci1709 = new Lcci1709()

    @Unroll
    def "getKthMagicNumber(#k) = #result"() {
        expect:
        result == this.lcci1709.getKthMagicNumber(k)

        where:
        k || result
//        1 || 1
        6 || 15
    }
}