package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0814}单元测试
 * @date 2020/08/07 14:45
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0814Spec extends Specification {
    Lcci0814 lcci0814 = new Lcci0814()

    @Unroll
    def "countEval(#s, #value) = #result"() {
        expect:
        result == this.lcci0814.countEval(s, value)

        where:
        s             | value || result
        "1^0|0|1"     | 0     || 2
        "0&0&0&1^1|0" | 1     || 10
    }
}