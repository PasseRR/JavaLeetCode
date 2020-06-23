package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0504}单元测试
 * @date 2020/06/23 09:38
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0504Spec extends Specification {
    Lcci0504 lcci0504 = new Lcci0504()

    @Unroll
    def "findClosedNumbers(#num) = #result"() {
        expect:
        result == this.lcci0504.findClosedNumbers(num)

        where:
        num        || result
        2          || [4, 1] as int[]
        1          || [2, -1] as int[]
        1156403390 || [1156403407, 1156403389] as int[]
        571603719  || [571603723, 571603696] as int[]
    }
}