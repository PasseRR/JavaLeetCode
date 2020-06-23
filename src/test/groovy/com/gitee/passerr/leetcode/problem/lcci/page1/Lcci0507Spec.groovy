package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0507}单元测试
 * @date 2020/06/23 09:50
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0507Spec extends Specification {
    Lcci0507 lcci0507 = new Lcci0507()

    @Unroll
    def "exchangeBits(#num) = #result"() {
        expect:
        result == this.lcci0507.exchangeBits(num)

        where:
        num || result
        2   || 1
        3   || 3
    }
}