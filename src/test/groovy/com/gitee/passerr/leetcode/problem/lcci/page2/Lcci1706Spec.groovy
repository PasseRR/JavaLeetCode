package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1706}单元测试
 * @date 2021/03/26 17:21
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1706Spec extends Specification {
    Lcci1706 lcci1706 = new Lcci1706()

    @Unroll
    def "numberOf2sInRange(#n) = #result"() {
        expect:
        result == this.lcci1706.numberOf2sInRange(n)

        where:
        n     || result
        25    || 9
        1234  || 389
        12345 || 5121
    }
}