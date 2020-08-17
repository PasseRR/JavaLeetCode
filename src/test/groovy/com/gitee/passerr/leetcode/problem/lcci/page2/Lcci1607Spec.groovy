package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1607}单元测试
 * @date 2020/08/17 15:18
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1607Spec extends Specification {
    Lcci1607 lcci1607 = new Lcci1607()

    @Unroll
    def "maximum(#a, #b) = #result"() {
        expect:
        result == this.lcci1607.maximum(a, b)

        where:
        a           | b           || result
        2147483647  | -2147483648 || 2147483647
        -2147483648 | 2147483647  || 2147483647
        1           | 2           || 2
        2           | 1           || 2
        -1          | -2          || -1
    }
}