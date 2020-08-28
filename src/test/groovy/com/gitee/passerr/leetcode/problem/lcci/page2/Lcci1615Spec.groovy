package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1615}单元测试
 * @date 2020/08/28 16:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1615Spec extends Specification {
    Lcci1615 lcci1615 = new Lcci1615()

    @Unroll
    def "masterMind(#solution, #guess) = #result"() {
        expect:
        result == this.lcci1615.masterMind(solution, guess)

        where:
        solution | guess  || result
        "YYRG"   | "RRRR" || [1, 0] as int[]
    }
}