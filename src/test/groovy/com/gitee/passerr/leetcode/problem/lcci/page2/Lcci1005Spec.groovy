package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1005}单元测试
 * @date 2020/08/10 10:54
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1005Spec extends Specification {
    Lcci1005 lcci1005 = new Lcci1005()

    @Unroll
    def "findString(#words, #s) = #result"() {
        expect:
        result == this.lcci1005.findString(words, s)

        where:
        words                                                                        | s      || result
        ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] as String[] | "ta"   || -1
        ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] as String[] | "ball" || 4
    }
}