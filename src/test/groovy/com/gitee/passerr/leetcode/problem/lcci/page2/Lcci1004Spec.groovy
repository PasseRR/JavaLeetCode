package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1004}单元测试
 * @date 2020/08/10 10:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1004Spec extends Specification {
    Lcci1004 lcci1004 = new Lcci1004()

    @Unroll
    def "findString(#words, #s) = #result"() {
        expect:
        result == this.lcci1004.findString(words, s)

        where:
        words                                                                        | s      || result
        ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] as String[] | "ta"   || -1
        ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] as String[] | "ball" || 4
    }
}