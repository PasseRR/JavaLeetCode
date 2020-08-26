package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1613}单元测试
 * @date 2020/08/25 14:17
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1613Spec extends Specification {
    Lcci1613 lcci1613 = new Lcci1613()

    @Unroll
    def "cutSquares(#square1, #square2) = #result"() {
        expect:
        result == this.lcci1613.cutSquares(square1, square2)

        where:
        square1             | square2            || result
        [-1, 1, 3] as int[] | [0, 0, 5] as int[] || [-1, 2.5, 5, 2.5] as double[]
    }
}