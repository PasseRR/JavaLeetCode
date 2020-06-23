package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0503}单元测试
 * @date 2020/06/23 09:36
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0503Spec extends Specification {
    Lcci0503 lcci0503 = new Lcci0503()

    @Unroll
    def "reverseBits(#num) = #result"() {
        expect:
        result == this.lcci0503.reverseBits(num)

        where:
        num  || result
        1775 || 8
        7    || 4
    }
}