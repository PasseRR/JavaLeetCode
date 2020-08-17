package com.gitee.passerr.leetcode.problem.lcci.page2


import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1606}单元测试
 * @date 2020/08/17 14:55
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1606Spec extends Specification {
    Lcci1606 lcci1606 = new Lcci1606()

    @Unroll
    def "smallestDifference(#a, #b) = #result"() {
        expect:
        result == this.lcci1606.smallestDifference(a, b)

        where:
        a                         | b                        || result
        [-2147483648, 1] as int[] | [2147483647, 0] as int[] || 1
    }
}