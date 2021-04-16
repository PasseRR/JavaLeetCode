package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1622}单元测试
 * @date 2021/04/16 10:17
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1622Spec extends Specification {
    Lcci1622 lcci1622 = new Lcci1622()

    @Unroll
    def "printKMoves(#K) = #result"() {
        expect:
        result == this.lcci1622.printKMoves(K)

        where:
        K || result
        0 || ["R"]
        1 || ["X", "D"]
        2 || ["_X", "LX"]
    }
}