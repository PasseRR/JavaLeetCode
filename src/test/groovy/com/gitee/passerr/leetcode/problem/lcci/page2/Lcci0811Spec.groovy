package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0811}单元测试
 * @date 2020/07/31 16:46
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0811Spec extends Specification {
    Lcci0811 lcci0811 = new Lcci0811()

    @Unroll
    def "waysToChange(#n) = #result"() {
        expect:
        result == this.lcci0811.waysToChange(n)

        where:
        n  || result
        5  || 2
        6  || 2
        10 || 4
    }
}